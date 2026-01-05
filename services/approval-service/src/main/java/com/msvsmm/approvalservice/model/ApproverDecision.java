package com.msvsmm.approvalservice.model;

import java.time.Instant;

public class ApproverDecision {
  private String id;
  private String approverId;
  private DecisionType decision;
  private String comment;
  private Instant decidedAt;

  public ApproverDecision() {
  }

  public ApproverDecision(
      String id,
      String approverId,
      DecisionType decision,
      String comment,
      Instant decidedAt
  ) {
    this.id = id;
    this.approverId = approverId;
    this.decision = decision;
    this.comment = comment;
    this.decidedAt = decidedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getApproverId() {
    return approverId;
  }

  public void setApproverId(String approverId) {
    this.approverId = approverId;
  }

  public DecisionType getDecision() {
    return decision;
  }

  public void setDecision(DecisionType decision) {
    this.decision = decision;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Instant getDecidedAt() {
    return decidedAt;
  }

  public void setDecidedAt(Instant decidedAt) {
    this.decidedAt = decidedAt;
  }
}
