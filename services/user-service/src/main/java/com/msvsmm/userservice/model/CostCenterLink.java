package com.msvsmm.userservice.model;

public class CostCenterLink {
  private String userId;
  private String costCenterId;

  public CostCenterLink() {
  }

  public CostCenterLink(String userId, String costCenterId) {
    this.userId = userId;
    this.costCenterId = costCenterId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getCostCenterId() {
    return costCenterId;
  }

  public void setCostCenterId(String costCenterId) {
    this.costCenterId = costCenterId;
  }
}
