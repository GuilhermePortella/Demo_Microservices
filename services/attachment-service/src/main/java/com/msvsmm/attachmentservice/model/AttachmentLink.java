package com.msvsmm.attachmentservice.model;

public class AttachmentLink {
  private String attachmentId;
  private String expenseId;

  public AttachmentLink() {
  }

  public AttachmentLink(String attachmentId, String expenseId) {
    this.attachmentId = attachmentId;
    this.expenseId = expenseId;
  }

  public String getAttachmentId() {
    return attachmentId;
  }

  public void setAttachmentId(String attachmentId) {
    this.attachmentId = attachmentId;
  }

  public String getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(String expenseId) {
    this.expenseId = expenseId;
  }
}
