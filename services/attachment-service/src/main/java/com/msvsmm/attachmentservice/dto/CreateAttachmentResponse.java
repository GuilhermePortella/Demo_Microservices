package com.msvsmm.attachmentservice.dto;

import com.msvsmm.attachmentservice.model.StorageRef;

public class CreateAttachmentResponse {
  private String id;
  private StorageRef storageRef;

  public CreateAttachmentResponse() {
  }

  public CreateAttachmentResponse(String id, StorageRef storageRef) {
    this.id = id;
    this.storageRef = storageRef;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public StorageRef getStorageRef() {
    return storageRef;
  }

  public void setStorageRef(StorageRef storageRef) {
    this.storageRef = storageRef;
  }
}
