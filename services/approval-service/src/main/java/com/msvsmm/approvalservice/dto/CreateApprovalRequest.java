package com.msvsmm.approvalservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class CreateApprovalRequest {
  @NotBlank
  private String expenseId;

  @NotEmpty
  private List<@NotBlank String> approverIds;

  public CreateApprovalRequest() {
  }

  public String getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(String expenseId) {
    this.expenseId = expenseId;
  }

  public List<String> getApproverIds() {
    return approverIds;
  }

  public void setApproverIds(List<String> approverIds) {
    this.approverIds = approverIds;
  }
}
