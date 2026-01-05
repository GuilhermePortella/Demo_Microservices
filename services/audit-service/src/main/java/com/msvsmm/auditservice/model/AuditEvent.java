package com.msvsmm.auditservice.model;

import java.time.Instant;

public class AuditEvent {
  private String id;
  private ResourceRef resourceRef;
  private Actor actor;
  private String action;
  private String payload;
  private Instant createdAt;

  public AuditEvent() {
  }

  public AuditEvent(
      String id,
      ResourceRef resourceRef,
      Actor actor,
      String action,
      String payload,
      Instant createdAt
  ) {
    this.id = id;
    this.resourceRef = resourceRef;
    this.actor = actor;
    this.action = action;
    this.payload = payload;
    this.createdAt = createdAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceRef getResourceRef() {
    return resourceRef;
  }

  public void setResourceRef(ResourceRef resourceRef) {
    this.resourceRef = resourceRef;
  }

  public Actor getActor() {
    return actor;
  }

  public void setActor(Actor actor) {
    this.actor = actor;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}
