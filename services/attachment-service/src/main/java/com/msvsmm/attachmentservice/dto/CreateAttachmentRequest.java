package com.msvsmm.attachmentservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class CreateAttachmentRequest {
  @NotBlank
  private String expenseId;

  @NotBlank
  private String fileName;

  @NotBlank
  private String contentType;

  @PositiveOrZero
  private long sizeBytes;

  private String provider;
  private String bucket;

  public CreateAttachmentRequest() {
  }

  public String getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(String expenseId) {
    this.expenseId = expenseId;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public long getSizeBytes() {
    return sizeBytes;
  }

  public void setSizeBytes(long sizeBytes) {
    this.sizeBytes = sizeBytes;
  }

  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public String getBucket() {
    return bucket;
  }

  public void setBucket(String bucket) {
    this.bucket = bucket;
  }
}
