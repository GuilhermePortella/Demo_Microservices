package com.msvsmm.expenseservice.integration;

public class BudgetCheckResult {
  private final boolean allowed;
  private final String reason;

  public BudgetCheckResult(boolean allowed, String reason) {
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
