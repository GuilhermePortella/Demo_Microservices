package com.msvsmm.expenseservice.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Expense {
  private String id;
  private String ownerId;
  private String costCenterId;
  private String currency;
  private String description;
  private ExpenseStatus status;
  private ExpenseTotals totals;
  private List<ExpenseItem> items = new ArrayList<>();
  private List<String> attachmentIds = new ArrayList<>();
  private String approvalId;
  private Instant createdAt;
  private Instant updatedAt;

  public Expense() {
  }

  public Expense(
      String id,
      String ownerId,
      String costCenterId,
      String currency,
      String description,
      ExpenseStatus status,
      ExpenseTotals totals,
      List<ExpenseItem> items,
      List<String> attachmentIds,
      String approvalId,
      Instant createdAt,
      Instant updatedAt
  ) {
    this.id = id;
    this.ownerId = ownerId;
    this.costCenterId = costCenterId;
    this.currency = currency;
    this.description = description;
    this.status = status;
    this.totals = totals;
    this.items = items != null ? items : new ArrayList<>();
    this.attachmentIds = attachmentIds != null ? attachmentIds : new ArrayList<>();
    this.approvalId = approvalId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public String getCostCenterId() {
    return costCenterId;
  }

  public void setCostCenterId(String costCenterId) {
    this.costCenterId = costCenterId;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ExpenseStatus getStatus() {
    return status;
  }

  public void setStatus(ExpenseStatus status) {
    this.status = status;
  }

  public ExpenseTotals getTotals() {
    return totals;
  }

  public void setTotals(ExpenseTotals totals) {
    this.totals = totals;
  }

  public List<ExpenseItem> getItems() {
    return items;
  }

  public void setItems(List<ExpenseItem> items) {
    this.items = items;
  }

  public List<String> getAttachmentIds() {
    return attachmentIds;
  }

  public void setAttachmentIds(List<String> attachmentIds) {
    this.attachmentIds = attachmentIds;
  }

  public String getApprovalId() {
    return approvalId;
  }

  public void setApprovalId(String approvalId) {
    this.approvalId = approvalId;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }
}
