package com.msvsmm.attachmentservice.model;

import java.time.Instant;

public class Attachment {
  private String id;
  private String expenseId;
  private String fileName;
  private String contentType;
  private long sizeBytes;
  private StorageRef storageRef;
  private Instant createdAt;

  public Attachment() {
  }

  public Attachment(
      String id,
      String expenseId,
      String fileName,
      String contentType,
      long sizeBytes,
      StorageRef storageRef,
      Instant createdAt
  ) {
    this.id = id;
    this.expenseId = expenseId;
    this.fileName = fileName;
    this.contentType = contentType;
    this.sizeBytes = sizeBytes;
    this.storageRef = storageRef;
    this.createdAt = createdAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public StorageRef getStorageRef() {
    return storageRef;
  }

  public void setStorageRef(StorageRef storageRef) {
    this.storageRef = storageRef;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}
