package com.msvsmm.auditservice.model;

public class ResourceRef {
  private String resource;
  private String resourceId;

  public ResourceRef() {
  }

  public ResourceRef(String resource, String resourceId) {
    this.resource = resource;
    this.resourceId = resourceId;
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
}
