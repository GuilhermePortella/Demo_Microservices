package com.msvsmm.policyservice.model;

import java.util.ArrayList;
import java.util.List;

public class PolicyRule {
  private String id;
  private String name;
  private String category;
  private List<Limit> limits = new ArrayList<>();

  public PolicyRule() {
  }

  public PolicyRule(String id, String name, String category, List<Limit> limits) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.limits = limits != null ? limits : new ArrayList<>();
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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public List<Limit> getLimits() {
    return limits;
  }

  public void setLimits(List<Limit> limits) {
    this.limits = limits;
  }
}
