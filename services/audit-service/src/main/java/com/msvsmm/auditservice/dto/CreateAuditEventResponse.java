package com.msvsmm.auditservice.dto;

import java.time.Instant;

public class CreateAuditEventResponse {
  private String id;
  private Instant createdAt;

  public CreateAuditEventResponse() {
  }

  public CreateAuditEventResponse(String id, Instant createdAt) {
    this.id = id;
    this.createdAt = createdAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}
