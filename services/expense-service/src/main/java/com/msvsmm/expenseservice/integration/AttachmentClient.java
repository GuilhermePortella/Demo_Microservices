package com.msvsmm.expenseservice.integration;

import java.util.List;

public interface AttachmentClient {
  void linkAttachments(String expenseId, List<String> attachmentIds);
}
