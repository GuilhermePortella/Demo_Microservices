package com.msvsmm.userservice.dto;

import jakarta.validation.constraints.Email;

public class UpdateUserRequest {
  private String name;

  @Email
  private String email;

  private String roleId;
  private String managerId;
  private String costCenterId;
  private Boolean active;

  public UpdateUserRequest() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getManagerId() {
    return managerId;
  }

  public void setManagerId(String managerId) {
    this.managerId = managerId;
  }

  public String getCostCenterId() {
    return costCenterId;
  }

  public void setCostCenterId(String costCenterId) {
    this.costCenterId = costCenterId;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }
}
