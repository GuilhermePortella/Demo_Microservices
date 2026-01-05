package com.msvsmm.notificationservice.model;

import java.time.Instant;

public class Notification {
  private String id;
  private String recipientId;
  private Channel channel;
  private String address;
  private String message;
  private DeliveryStatus status;
  private String errorMessage;
  private Instant createdAt;
  private Instant updatedAt;
  private Instant sentAt;

  public Notification() {
  }

  public Notification(
      String id,
      String recipientId,
      Channel channel,
      String address,
      String message,
      DeliveryStatus status,
      String errorMessage,
      Instant createdAt,
      Instant updatedAt,
      Instant sentAt
  ) {
    this.id = id;
    this.recipientId = recipientId;
    this.channel = channel;
    this.address = address;
    this.message = message;
    this.status = status;
    this.errorMessage = errorMessage;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.sentAt = sentAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRecipientId() {
    return recipientId;
  }

  public void setRecipientId(String recipientId) {
    this.recipientId = recipientId;
  }

  public Channel getChannel() {
    return channel;
  }

  public void setChannel(Channel channel) {
    this.channel = channel;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public DeliveryStatus getStatus() {
    return status;
  }

  public void setStatus(DeliveryStatus status) {
    this.status = status;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
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

  public Instant getSentAt() {
    return sentAt;
  }

  public void setSentAt(Instant sentAt) {
    this.sentAt = sentAt;
  }
}
