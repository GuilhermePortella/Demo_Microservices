package com.msvsmm.policyservice.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Policy {
  private String id;
  private String area;
  private String name;
  private String description;
  private List<PolicyRule> rules = new ArrayList<>();
  private Instant createdAt;
  private Instant updatedAt;

  public Policy() {
  }

  public Policy(
      String id,
      String area,
      String name,
      String description,
      List<PolicyRule> rules,
      Instant createdAt,
      Instant updatedAt
  ) {
    this.id = id;
    this.area = area;
    this.name = name;
    this.description = description;
    this.rules = rules != null ? rules : new ArrayList<>();
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<PolicyRule> getRules() {
    return rules;
  }

  public void setRules(List<PolicyRule> rules) {
    this.rules = rules;
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
