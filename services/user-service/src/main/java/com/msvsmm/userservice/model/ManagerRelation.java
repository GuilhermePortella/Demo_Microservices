package com.msvsmm.userservice.model;

public class ManagerRelation {
  private String managerId;
  private String reportId;

  public ManagerRelation() {
  }

  public ManagerRelation(String managerId, String reportId) {
    this.managerId = managerId;
    this.reportId = reportId;
  }

  public String getManagerId() {
    return managerId;
  }

  public void setManagerId(String managerId) {
    this.managerId = managerId;
  }

  public String getReportId() {
    return reportId;
  }

  public void setReportId(String reportId) {
    this.reportId = reportId;
  }
}
