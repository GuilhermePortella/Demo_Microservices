package com.msvsmm.attachmentservice.repository;

import com.msvsmm.attachmentservice.model.Attachment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryAttachmentRepository implements AttachmentRepository {
  private final Map<String, Attachment> store = new ConcurrentHashMap<>();

  @Override
  public Attachment save(Attachment attachment) {
    store.put(attachment.getId(), attachment);
    return attachment;
  }

  @Override
  public Optional<Attachment> findById(String id) {
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public void deleteById(String id) {
    store.remove(id);
  }

  @Override
  public List<Attachment> findAll() {
    return new ArrayList<>(store.values());
  }
}
