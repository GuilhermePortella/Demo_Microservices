package com.msvsmm.policyservice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class PolicyValidationRequest {
  @NotBlank
  private String area;

  @NotBlank
  private String currency;

  @Valid
  private List<ExpenseItemDto> items;

  public PolicyValidationRequest() {
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public List<ExpenseItemDto> getItems() {
    return items;
  }

  public void setItems(List<ExpenseItemDto> items) {
    this.items = items;
  }
}
