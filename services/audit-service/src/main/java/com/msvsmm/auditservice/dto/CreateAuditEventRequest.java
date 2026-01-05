package com.msvsmm.auditservice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateAuditEventRequest {
  @NotBlank
  private String resource;

  @NotBlank
  private String resourceId;

  @NotBlank
  private String action;

  @Valid
  @NotNull
  private ActorDto actor;

  private String payload;

  public CreateAuditEventRequest() {
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public ActorDto getActor() {
    return actor;
  }

  public void setActor(ActorDto actor) {
    this.actor = actor;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }
}
