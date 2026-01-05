package com.msvsmm.attachmentservice.audit;

import com.msvsmm.attachmentservice.model.Attachment;

public interface AuditPublisher {
  void recordUpload(Attachment attachment);

  void recordDeletion(Attachment attachment);
}
