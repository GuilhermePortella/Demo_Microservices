package com.msvsmm.policyservice.dto;

public class PolicyValidationResponse {
  private boolean allowed;
  private String reason;

  public PolicyValidationResponse() {
  }

  public PolicyValidationResponse(boolean allowed, String reason) {
    this.allowed = allowed;
    this.reason = reason;
  }

  public boolean isAllowed() {
    return allowed;
  }

  public void setAllowed(boolean allowed) {
    this.allowed = allowed;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }
}
