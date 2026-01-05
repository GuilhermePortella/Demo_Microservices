package com.msvsmm.approvalservice.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Approval {
  private String id;
  private String expenseId;
  private ApprovalStatus status;
  private Instant createdAt;
  private Instant updatedAt;
  private List<ApprovalStep> steps = new ArrayList<>();
  private List<ApproverDecision> decisions = new ArrayList<>();

  public Approval() {
  }

  public Approval(
      String id,
      String expenseId,
      ApprovalStatus status,
      Instant createdAt,
      Instant updatedAt,
      List<ApprovalStep> steps,
      List<ApproverDecision> decisions
  ) {
    this.id = id;
    this.expenseId = expenseId;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.steps = steps != null ? steps : new ArrayList<>();
    this.decisions = decisions != null ? decisions : new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(String expenseId) {
    this.expenseId = expenseId;
  }

  public ApprovalStatus getStatus() {
    return status;
  }

  public void setStatus(ApprovalStatus status) {
    this.status = status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public List<ApprovalStep> getSteps() {
    return steps;
  }

  public void setSteps(List<ApprovalStep> steps) {
    this.steps = steps;
  }

  public List<ApproverDecision> getDecisions() {
    return decisions;
  }

  public void setDecisions(List<ApproverDecision> decisions) {
    this.decisions = decisions;
  }
}
