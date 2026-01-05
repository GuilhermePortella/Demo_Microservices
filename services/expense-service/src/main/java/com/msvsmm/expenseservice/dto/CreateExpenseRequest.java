package com.msvsmm.expenseservice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class CreateExpenseRequest {
  @NotBlank
  private String ownerId;

  @NotBlank
  private String costCenterId;

  @NotBlank
  private String currency;

  private String description;

  @Valid
  private List<ExpenseItemRequest> items;

  private List<String> attachmentIds;

  public CreateExpenseRequest() {
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
