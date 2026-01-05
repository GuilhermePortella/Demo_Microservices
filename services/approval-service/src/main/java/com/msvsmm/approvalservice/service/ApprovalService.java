package com.msvsmm.approvalservice.service;

import com.msvsmm.approvalservice.audit.AuditPublisher;
import com.msvsmm.approvalservice.dto.CreateApprovalRequest;
import com.msvsmm.approvalservice.dto.DecisionRequest;
import com.msvsmm.approvalservice.model.Approval;
import com.msvsmm.approvalservice.model.ApprovalStatus;
import com.msvsmm.approvalservice.model.ApprovalStep;
import com.msvsmm.approvalservice.model.ApproverDecision;
import com.msvsmm.approvalservice.model.DecisionType;
import com.msvsmm.approvalservice.model.StepStatus;
import com.msvsmm.approvalservice.repository.ApprovalRepository;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ApprovalService {
  private final ApprovalRepository repository;
  private final AuditPublisher auditPublisher;

  public ApprovalService(ApprovalRepository repository, AuditPublisher auditPublisher) {
    this.repository = repository;
    this.auditPublisher = auditPublisher;
  }

  public Approval createApproval(CreateApprovalRequest request) {
    String id = UUID.randomUUID().toString();
    Instant now = Instant.now();
    List<ApprovalStep> steps = new ArrayList<>();
    int stepOrder = 1;
    for (String approverId : request.getApproverIds()) {
      steps.add(new ApprovalStep(stepOrder++, approverId, StepStatus.PENDING));
    }

    Approval approval = new Approval(
        id,
        request.getExpenseId(),
        ApprovalStatus.IN_PROGRESS,
        now,
        now,
        steps,
        new ArrayList<>()
    );
    repository.save(approval);
    auditPublisher.recordApprovalCreated(approval);
    return approval;
  }

  public Approval getApproval(String id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Approval not found"));
  }

  public List<Approval> getApprovals(String expenseId) {
    if (expenseId == null || expenseId.isBlank()) {
      return repository.findAll();
    }
    return repository.findByExpenseId(expenseId);
  }

  public Approval recordDecision(String approvalId, DecisionRequest request) {
    Approval approval = getApproval(approvalId);
    if (approval.getStatus() == ApprovalStatus.APPROVED
        || approval.getStatus() == ApprovalStatus.REJECTED) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Approval is already completed");
    }

    ApprovalStep step = findStep(approval, request.getApproverId());
    if (step.getStatus() != StepStatus.PENDING) {
      throw new ResponseStatusException(
          HttpStatus.CONFLICT,
          "Decision already registered for approver"
      );
    }

    StepStatus stepStatus = request.getDecision() == DecisionType.APPROVE
        ? StepStatus.APPROVED
        : StepStatus.REJECTED;
    step.setStatus(stepStatus);

    ApproverDecision decision = new ApproverDecision(
        UUID.randomUUID().toString(),
        request.getApproverId(),
        request.getDecision(),
        request.getComment(),
        Instant.now()
    );
    approval.getDecisions().add(decision);

    if (request.getDecision() == DecisionType.REJECT) {
      approval.setStatus(ApprovalStatus.REJECTED);
    } else {
      boolean allApproved = approval.getSteps().stream()
          .allMatch(stepItem -> stepItem.getStatus() == StepStatus.APPROVED);
      approval.setStatus(allApproved ? ApprovalStatus.APPROVED : ApprovalStatus.IN_PROGRESS);
    }

    approval.setUpdatedAt(Instant.now());
    repository.save(approval);
    auditPublisher.recordDecision(approval, decision);
    return approval;
  }

  private ApprovalStep findStep(Approval approval, String approverId) {
    for (ApprovalStep step : approval.getSteps()) {
      if (step.getApproverId().equals(approverId)) {
        return step;
      }
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Approver not part of workflow");
  }
}
