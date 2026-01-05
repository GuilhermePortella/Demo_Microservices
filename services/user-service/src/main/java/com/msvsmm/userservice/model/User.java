package com.msvsmm.userservice.model;

import java.time.Instant;

public class User {
  private String id;
  private String name;
  private String email;
  private String roleId;
  private String managerId;
  private String costCenterId;
  private boolean active;
  private Instant createdAt;
  private Instant updatedAt;

  public User() {
  }

  public User(
      String id,
      String name,
      String email,
      String roleId,
      String managerId,
      String costCenterId,
      boolean active,
      Instant createdAt,
      Instant updatedAt
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.roleId = roleId;
    this.managerId = managerId;
    this.costCenterId = costCenterId;
    this.active = active;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
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
