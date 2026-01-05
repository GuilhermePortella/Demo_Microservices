package com.msvsmm.budgetservice.model;

public class CostCenter {
  private String id;
  private String name;

  public CostCenter() {
  }

  public CostCenter(String id, String name) {
    this.id = id;
    this.name = name;
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
}
