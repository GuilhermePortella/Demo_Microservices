package com.msvsmm.approvalservice.dto;

import com.msvsmm.approvalservice.model.DecisionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DecisionRequest {
  @NotBlank
  private String approverId;

  @NotNull
  private DecisionType decision;

  private String comment;

  public DecisionRequest() {
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
}
