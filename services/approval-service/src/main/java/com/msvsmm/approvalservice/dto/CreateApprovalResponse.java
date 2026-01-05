package com.msvsmm.approvalservice.dto;

import com.msvsmm.approvalservice.model.ApprovalStatus;

public class CreateApprovalResponse {
  private String id;
  private ApprovalStatus status;

  public CreateApprovalResponse() {
  }

  public CreateApprovalResponse(String id, ApprovalStatus status) {
    this.id = id;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ApprovalStatus getStatus() {
    return status;
  }

  public void setStatus(ApprovalStatus status) {
    this.status = status;
  }
}
