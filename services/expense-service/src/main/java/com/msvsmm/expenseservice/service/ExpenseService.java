package com.msvsmm.expenseservice.service;

import com.msvsmm.expenseservice.audit.AuditPublisher;
import com.msvsmm.expenseservice.dto.CreateExpenseRequest;
import com.msvsmm.expenseservice.dto.ExpenseItemRequest;
import com.msvsmm.expenseservice.dto.UpdateExpenseRequest;
import com.msvsmm.expenseservice.integration.ApprovalClient;
import com.msvsmm.expenseservice.integration.AttachmentClient;
import com.msvsmm.expenseservice.integration.BudgetCheckResult;
import com.msvsmm.expenseservice.integration.BudgetClient;
import com.msvsmm.expenseservice.integration.PolicyCheckResult;
import com.msvsmm.expenseservice.integration.PolicyClient;
import com.msvsmm.expenseservice.integration.UserClient;
import com.msvsmm.expenseservice.model.Expense;
import com.msvsmm.expenseservice.model.ExpenseItem;
import com.msvsmm.expenseservice.model.ExpenseStatus;
import com.msvsmm.expenseservice.model.ExpenseTotals;
import com.msvsmm.expenseservice.notification.NotificationPublisher;
import com.msvsmm.expenseservice.repository.ExpenseRepository;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ExpenseService {
  private final ExpenseRepository repository;
  private final PolicyClient policyClient;
  private final BudgetClient budgetClient;
  private final ApprovalClient approvalClient;
  private final AttachmentClient attachmentClient;
  private final UserClient userClient;
  private final AuditPublisher auditPublisher;
  private final NotificationPublisher notificationPublisher;

  public ExpenseService(
      ExpenseRepository repository,
      PolicyClient policyClient,
      BudgetClient budgetClient,
      ApprovalClient approvalClient,
      AttachmentClient attachmentClient,
      UserClient userClient,
      AuditPublisher auditPublisher,
      NotificationPublisher notificationPublisher
  ) {
    this.repository = repository;
    this.policyClient = policyClient;
    this.budgetClient = budgetClient;
    this.approvalClient = approvalClient;
    this.attachmentClient = attachmentClient;
    this.userClient = userClient;
    this.auditPublisher = auditPublisher;
    this.notificationPublisher = notificationPublisher;
  }

  public Expense createExpense(CreateExpenseRequest request) {
    if (!userClient.userExists(request.getOwnerId())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Owner not found");
    }

    List<ExpenseItem> items = mapItems(request.getItems());
    ExpenseTotals totals = computeTotals(items);
    Instant now = Instant.now();

    Expense expense = new Expense(
        UUID.randomUUID().toString(),
        request.getOwnerId(),
        request.getCostCenterId(),
        request.getCurrency(),
        request.getDescription(),
        ExpenseStatus.DRAFT,
        totals,
        items,
        copyAttachments(request.getAttachmentIds()),
        null,
        now,
        now
    );

    repository.save(expense);
    if (!expense.getAttachmentIds().isEmpty()) {
      attachmentClient.linkAttachments(expense.getId(), expense.getAttachmentIds());
    }
    auditPublisher.recordCreated(expense);
    notificationPublisher.notifyCreated(expense);
    return expense;
  }

  public Expense getExpense(String id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found"));
  }

  public List<Expense> listExpenses(ExpenseStatus status, String ownerId) {
    boolean hasOwner = hasValue(ownerId);
    if (status != null && hasOwner) {
      return repository.findByOwnerIdAndStatus(ownerId, status);
    }
    if (status != null) {
      return repository.findByStatus(status);
    }
    if (hasOwner) {
      return repository.findByOwnerId(ownerId);
    }
    return repository.findAll();
  }

  public Expense updateExpense(String id, UpdateExpenseRequest request) {
    Expense expense = getExpense(id);
    boolean changed = false;

    if (request.getDescription() != null) {
      ensureDraft(expense, "Only draft expenses can be edited");
      expense.setDescription(request.getDescription());
      changed = true;
    }

    if (request.getItems() != null) {
      ensureDraft(expense, "Only draft expenses can be edited");
      List<ExpenseItem> items = mapItems(request.getItems());
      expense.setItems(items);
      expense.setTotals(computeTotals(items));
      changed = true;
    }

    if (request.getAttachmentIds() != null) {
      ensureDraft(expense, "Only draft expenses can be edited");
      expense.setAttachmentIds(copyAttachments(request.getAttachmentIds()));
      if (!expense.getAttachmentIds().isEmpty()) {
        attachmentClient.linkAttachments(expense.getId(), expense.getAttachmentIds());
      }
      changed = true;
    }

    if (request.getStatus() != null) {
      applyStatusChange(expense, request.getStatus());
      changed = true;
    }

    if (changed) {
      expense.setUpdatedAt(Instant.now());
      repository.save(expense);
    }

    return expense;
  }

  private void applyStatusChange(Expense expense, ExpenseStatus targetStatus) {
    if (targetStatus == expense.getStatus()) {
      return;
    }
    if (targetStatus == ExpenseStatus.SUBMITTED) {
      submitExpense(expense);
      return;
    }
    if (targetStatus == ExpenseStatus.APPROVED || targetStatus == ExpenseStatus.REJECTED) {
      finalizeExpense(expense, targetStatus);
      return;
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid status transition");
  }

  private void submitExpense(Expense expense) {
    ensureDraft(expense, "Only draft expenses can be submitted");
    if (expense.getItems() == null || expense.getItems().isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Expense must have items before submit");
    }

    PolicyCheckResult policyResult = policyClient.validate(expense);
    if (!policyResult.isAllowed()) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, policyResult.getReason());
    }

    BudgetCheckResult budgetResult = budgetClient.check(expense);
    if (!budgetResult.isAllowed()) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, budgetResult.getReason());
    }

    String approvalId = approvalClient.startApproval(expense);
    expense.setApprovalId(approvalId);
    expense.setStatus(ExpenseStatus.SUBMITTED);
    auditPublisher.recordSubmitted(expense);
    notificationPublisher.notifySubmitted(expense);
  }

  private void finalizeExpense(Expense expense, ExpenseStatus status) {
    if (expense.getStatus() != ExpenseStatus.SUBMITTED) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Expense is not submitted");
    }
    expense.setStatus(status);
    auditPublisher.recordStatusChange(expense);
    notificationPublisher.notifyStatusChange(expense);
  }

  private void ensureDraft(Expense expense, String message) {
    if (expense.getStatus() != ExpenseStatus.DRAFT) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, message);
    }
  }

  private List<ExpenseItem> mapItems(List<ExpenseItemRequest> items) {
    if (items == null) {
      return new ArrayList<>();
    }
    List<ExpenseItem> mapped = new ArrayList<>();
    for (ExpenseItemRequest item : items) {
      mapped.add(new ExpenseItem(
          UUID.randomUUID().toString(),
          item.getDescription(),
          item.getCategory(),
          item.getAmount()
      ));
    }
    return mapped;
  }

  private ExpenseTotals computeTotals(List<ExpenseItem> items) {
    BigDecimal total = BigDecimal.ZERO;
    int count = 0;
    if (items != null) {
      for (ExpenseItem item : items) {
        if (item.getAmount() != null) {
          total = total.add(item.getAmount());
        }
        count++;
      }
    }
    return new ExpenseTotals(total, count);
  }

  private List<String> copyAttachments(List<String> attachmentIds) {
    return attachmentIds == null ? new ArrayList<>() : new ArrayList<>(attachmentIds);
  }

  private boolean hasValue(String value) {
    return value != null && !value.isBlank();
  }
}
