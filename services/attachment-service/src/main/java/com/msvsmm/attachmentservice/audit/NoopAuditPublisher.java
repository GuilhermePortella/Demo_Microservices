package com.msvsmm.attachmentservice.audit;

import com.msvsmm.attachmentservice.model.Attachment;
import org.springframework.stereotype.Component;

@Component
public class NoopAuditPublisher implements AuditPublisher {
  @Override
  public void recordUpload(Attachment attachment) {
  }

  @Override
  public void recordDeletion(Attachment attachment) {
  }
}
