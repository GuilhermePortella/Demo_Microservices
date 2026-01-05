package com.msvsmm.expenseservice.model;

import java.math.BigDecimal;

public class ExpenseItem {
  private String id;
  private String description;
  private String category;
  private BigDecimal amount;

  public ExpenseItem() {
  }

  public ExpenseItem(String id, String description, String category, BigDecimal amount) {
    this.id = id;
    this.description = description;
    this.category = category;
    this.amount = amount;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
