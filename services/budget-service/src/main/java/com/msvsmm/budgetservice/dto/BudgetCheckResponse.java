package com.msvsmm.budgetservice.dto;

import com.msvsmm.budgetservice.model.Balance;

public class BudgetCheckResponse {
  private boolean allowed;
  private String reason;
  private String budgetId;
  private Balance balance;

  public BudgetCheckResponse() {
  }

  public BudgetCheckResponse(boolean allowed, String reason, String budgetId, Balance balance) {
    this.allowed = allowed;
    this.reason = reason;
    this.budgetId = budgetId;
    this.balance = balance;
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

  public String getBudgetId() {
    return budgetId;
  }

  public void setBudgetId(String budgetId) {
    this.budgetId = budgetId;
  }

  public Balance getBalance() {
    return balance;
  }

  public void setBalance(Balance balance) {
    this.balance = balance;
  }
}
