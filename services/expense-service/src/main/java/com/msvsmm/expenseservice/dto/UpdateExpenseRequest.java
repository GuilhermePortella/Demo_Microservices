package com.msvsmm.expenseservice.dto;

import com.msvsmm.expenseservice.model.ExpenseStatus;
import jakarta.validation.Valid;
import java.util.List;

public class UpdateExpenseRequest {
  private ExpenseStatus status;
  private String description;

  @Valid
  private List<ExpenseItemRequest> items;

  private List<String> attachmentIds;

  public UpdateExpenseRequest() {
  }

  public ExpenseStatus getStatus() {
    return status;
  }

  public void setStatus(ExpenseStatus status) {
    this.status = status;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<ExpenseItemRequest> getItems() {
    return items;
  }

  public void setItems(List<ExpenseItemRequest> items) {
    this.items = items;
  }

  public List<String> getAttachmentIds() {
    return attachmentIds;
  }

  public void setAttachmentIds(List<String> attachmentIds) {
    this.attachmentIds = attachmentIds;
  }
}
