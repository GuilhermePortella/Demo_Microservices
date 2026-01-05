package com.msvsmm.attachmentservice.model;

public class StorageRef {
  private String provider;
  private String bucket;
  private String objectKey;

  public StorageRef() {
  }

  public StorageRef(String provider, String bucket, String objectKey) {
    this.provider = provider;
    this.bucket = bucket;
    this.objectKey = objectKey;
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

  public String getObjectKey() {
    return objectKey;
  }

  public void setObjectKey(String objectKey) {
    this.objectKey = objectKey;
  }
}
