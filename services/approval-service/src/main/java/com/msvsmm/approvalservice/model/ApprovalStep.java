package com.msvsmm.approvalservice.model;

public class ApprovalStep {
  private int stepOrder;
  private String approverId;
  private StepStatus status;

  public ApprovalStep() {
  }

  public ApprovalStep(int stepOrder, String approverId, StepStatus status) {
    this.stepOrder = stepOrder;
    this.approverId = approverId;
    this.status = status;
  }

  public int getStepOrder() {
    return stepOrder;
  }

  public void setStepOrder(int stepOrder) {
    this.stepOrder = stepOrder;
  }

  public String getApproverId() {
    return approverId;
  }

  public void setApproverId(String approverId) {
    this.approverId = approverId;
  }

  public StepStatus getStatus() {
    return status;
  }

  public void setStatus(StepStatus status) {
    this.status = status;
  }
}
