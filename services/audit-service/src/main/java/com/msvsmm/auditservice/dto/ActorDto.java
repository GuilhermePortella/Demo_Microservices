package com.msvsmm.auditservice.dto;

import jakarta.validation.constraints.NotBlank;

public class ActorDto {
  @NotBlank
  private String id;

  private String name;

  @NotBlank
  private String type;

  public ActorDto() {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
