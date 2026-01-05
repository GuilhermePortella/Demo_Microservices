package com.msvsmm.attachmentservice.controller;

import com.msvsmm.attachmentservice.dto.CreateAttachmentRequest;
import com.msvsmm.attachmentservice.dto.CreateAttachmentResponse;
import com.msvsmm.attachmentservice.model.Attachment;
import com.msvsmm.attachmentservice.service.AttachmentService;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {
  private final AttachmentService attachmentService;

  public AttachmentController(AttachmentService attachmentService) {
    this.attachmentService = attachmentService;
  }

  @PostMapping
  public ResponseEntity<CreateAttachmentResponse> create(
      @Valid @RequestBody CreateAttachmentRequest request
  ) {
    Attachment attachment = attachmentService.createAttachment(request);
    URI location = URI.create("/attachments/" + attachment.getId());
    CreateAttachmentResponse response = new CreateAttachmentResponse(
        attachment.getId(),
        attachment.getStorageRef()
    );
    return ResponseEntity.created(location).body(response);
  }

  @GetMapping("/{id}")
  public Attachment get(@PathVariable String id) {
    return attachmentService.getAttachment(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    attachmentService.deleteAttachment(id);
    return ResponseEntity.noContent().build();
  }
}
