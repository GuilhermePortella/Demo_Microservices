package com.msvsmm.notificationservice.delivery;

public class DeliveryResult {
  private final boolean success;
  private final String errorMessage;

  public DeliveryResult(boolean success, String errorMessage) {
    this.success = success;
    this.errorMessage = errorMessage;
  }

  public boolean isSuccess() {
    return success;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
