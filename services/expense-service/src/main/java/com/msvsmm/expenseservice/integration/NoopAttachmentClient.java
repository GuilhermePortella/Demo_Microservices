package com.msvsmm.expenseservice.integration;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class NoopAttachmentClient implements AttachmentClient {
  @Override
  public void linkAttachments(String expenseId, List<String> attachmentIds) {
  }
}
