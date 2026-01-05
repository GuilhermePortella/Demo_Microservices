package com.msvsmm.attachmentservice.repository;

import com.msvsmm.attachmentservice.model.Attachment;
import java.util.List;
import java.util.Optional;

public interface AttachmentRepository {
  Attachment save(Attachment attachment);

  Optional<Attachment> findById(String id);

  void deleteById(String id);

  List<Attachment> findAll();
}
