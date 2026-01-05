package com.msvsmm.notificationservice.dto;

import com.msvsmm.notificationservice.model.DeliveryStatus;

public class CreateNotificationResponse {
  private String id;
  private DeliveryStatus status;

  public CreateNotificationResponse() {
  }

  public CreateNotificationResponse(String id, DeliveryStatus status) {
    this.id = id;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DeliveryStatus getStatus() {
    return status;
  }

  public void setStatus(DeliveryStatus status) {
    this.status = status;
  }
}
