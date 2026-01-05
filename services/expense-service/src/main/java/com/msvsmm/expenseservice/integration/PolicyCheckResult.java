package com.msvsmm.expenseservice.integration;

public class PolicyCheckResult {
  private final boolean allowed;
  private final String reason;

  public PolicyCheckResult(boolean allowed, String reason) {
    this.allowed = allowed;
    this.reason = reason;
  }

  public boolean isAllowed() {
    return allowed;
  }

  public String getReason() {
    return reason;
  }
}
