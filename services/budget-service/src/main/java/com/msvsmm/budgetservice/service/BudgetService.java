package com.msvsmm.budgetservice.service;

import com.msvsmm.budgetservice.audit.BudgetAuditPublisher;
import com.msvsmm.budgetservice.dto.BudgetCheckRequest;
import com.msvsmm.budgetservice.dto.BudgetCheckResponse;
import com.msvsmm.budgetservice.model.Balance;
import com.msvsmm.budgetservice.model.Budget;
import com.msvsmm.budgetservice.model.CostCenter;
import com.msvsmm.budgetservice.repository.BudgetRepository;
import com.msvsmm.budgetservice.repository.CostCenterRepository;
import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BudgetService {
  private final BudgetRepository budgetRepository;
  private final CostCenterRepository costCenterRepository;
  private final BudgetAuditPublisher auditPublisher;

  public BudgetService(
      BudgetRepository budgetRepository,
      CostCenterRepository costCenterRepository,
      BudgetAuditPublisher auditPublisher
  ) {
    this.budgetRepository = budgetRepository;
    this.costCenterRepository = costCenterRepository;
    this.auditPublisher = auditPublisher;
  }

  public BudgetCheckResponse checkBudget(BudgetCheckRequest request) {
    Budget budget = budgetRepository.findByCostCenterId(request.getCostCenterId()).orElse(null);
    if (budget == null) {
      return new BudgetCheckResponse(false, "Budget not found", null, null);
    }
    if (!budget.getCurrency().equalsIgnoreCase(request.getCurrency())) {
      return new BudgetCheckResponse(false, "Currency mismatch", budget.getId(), toBalance(budget));
    }

    Balance balance = toBalance(budget);
    boolean allowed = balance.getAvailableAmount().compareTo(request.getAmount()) >= 0;
    String reason = allowed ? "OK" : "Insufficient balance";
    auditPublisher.recordCheck(budget, reason);
    return new BudgetCheckResponse(allowed, reason, budget.getId(), balance);
  }

  public Budget getBudget(String id) {
    return budgetRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Budget not found"));
  }

  public CostCenter getCostCenter(String id) {
    return costCenterRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cost center not found"));
  }

  private Balance toBalance(Budget budget) {
    BigDecimal total = zeroIfNull(budget.getTotalAmount());
    BigDecimal reserved = zeroIfNull(budget.getReservedAmount());
    BigDecimal consumed = zeroIfNull(budget.getConsumedAmount());
    BigDecimal available = total.subtract(reserved).subtract(consumed);
    return new Balance(total, reserved, consumed, available);
  }

  private BigDecimal zeroIfNull(BigDecimal value) {
    return value == null ? BigDecimal.ZERO : value;
  }
}
