package com.msvsmm.attachmentservice.service;

import com.msvsmm.attachmentservice.audit.AuditPublisher;
import com.msvsmm.attachmentservice.dto.CreateAttachmentRequest;
import com.msvsmm.attachmentservice.model.Attachment;
import com.msvsmm.attachmentservice.model.StorageRef;
import com.msvsmm.attachmentservice.repository.AttachmentRepository;
import java.time.Instant;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AttachmentService {
  private static final String DEFAULT_PROVIDER = "local";
  private static final String DEFAULT_BUCKET = "attachments";

  private final AttachmentRepository repository;
  private final AuditPublisher auditPublisher;

  public AttachmentService(AttachmentRepository repository, AuditPublisher auditPublisher) {
    this.repository = repository;
    this.auditPublisher = auditPublisher;
  }

  public Attachment createAttachment(CreateAttachmentRequest request) {
    String id = UUID.randomUUID().toString();
    String provider = hasValue(request.getProvider()) ? request.getProvider() : DEFAULT_PROVIDER;
    String bucket = hasValue(request.getBucket()) ? request.getBucket() : DEFAULT_BUCKET;
    String objectKey = "attachments/" + id + "/" + request.getFileName();
    StorageRef storageRef = new StorageRef(provider, bucket, objectKey);

    Attachment attachment = new Attachment(
        id,
        request.getExpenseId(),
        request.getFileName(),
        request.getContentType(),
        request.getSizeBytes(),
        storageRef,
        Instant.now()
    );

    repository.save(attachment);
    auditPublisher.recordUpload(attachment);
    return attachment;
  }

  public Attachment getAttachment(String id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attachment not found"));
  }

  public void deleteAttachment(String id) {
    Attachment attachment = getAttachment(id);
    repository.deleteById(id);
    auditPublisher.recordDeletion(attachment);
  }

  private boolean hasValue(String value) {
    return value != null && !value.isBlank();
  }
}
