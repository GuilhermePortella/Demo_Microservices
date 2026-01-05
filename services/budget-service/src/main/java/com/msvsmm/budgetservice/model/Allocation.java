package com.msvsmm.budgetservice.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Allocation {
  private String id;
  private String expenseId;
  private BigDecimal amount;
  private AllocationStatus status;
  private Instant createdAt;

  public Allocation() {
  }

  public Allocation(
      String id,
      String expenseId,
      BigDecimal amount,
      AllocationStatus status,
      Instant createdAt
  ) {
    this.id = id;
    this.expenseId = expenseId;
    this.amount = amount;
    this.status = status;
    this.createdAt = createdAt;
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

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public AllocationStatus getStatus() {
    return status;
  }

  public void setStatus(AllocationStatus status) {
    this.status = status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}
