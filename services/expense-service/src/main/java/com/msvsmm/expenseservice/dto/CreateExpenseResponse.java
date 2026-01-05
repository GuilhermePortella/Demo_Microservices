package com.msvsmm.expenseservice.dto;

import com.msvsmm.expenseservice.model.ExpenseStatus;

public class CreateExpenseResponse {
  private String id;
  private ExpenseStatus status;

  public CreateExpenseResponse() {
  }

  public CreateExpenseResponse(String id, ExpenseStatus status) {
    this.id = id;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ExpenseStatus getStatus() {
    return status;
  }

  public void setStatus(ExpenseStatus status) {
    this.status = status;
  }
}
