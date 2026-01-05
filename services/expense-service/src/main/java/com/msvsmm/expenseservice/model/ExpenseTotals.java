package com.msvsmm.expenseservice.model;

import java.math.BigDecimal;

public class ExpenseTotals {
  private BigDecimal totalAmount;
  private int itemCount;

  public ExpenseTotals() {
  }

  public ExpenseTotals(BigDecimal totalAmount, int itemCount) {
    this.totalAmount = totalAmount;
    this.itemCount = itemCount;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public int getItemCount() {
    return itemCount;
  }

  public void setItemCount(int itemCount) {
    this.itemCount = itemCount;
  }
}
