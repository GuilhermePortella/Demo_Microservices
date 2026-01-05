package com.msvsmm.auditservice.repository;

import com.msvsmm.auditservice.model.AuditEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryAuditEventRepository implements AuditEventRepository {
  private final Map<String, AuditEvent> store = new ConcurrentHashMap<>();

  @Override
  public AuditEvent save(AuditEvent event) {
    store.put(event.getId(), event);
    return event;
  }

  @Override
  public Optional<AuditEvent> findById(String id) {
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public List<AuditEvent> findAll() {
    return new ArrayList<>(store.values());
  }

  @Override
  public List<AuditEvent> findByResource(String resource) {
    return store.values()
        .stream()
        .filter(event -> resource.equals(event.getResourceRef().getResource()))
        .collect(Collectors.toList());
  }

  @Override
  public List<AuditEvent> findByResourceId(String resourceId) {
    return store.values()
        .stream()
        .filter(event -> resourceId.equals(event.getResourceRef().getResourceId()))
        .collect(Collectors.toList());
  }

  @Override
  public List<AuditEvent> findByResourceAndResourceId(String resource, String resourceId) {
    return store.values()
        .stream()
        .filter(event -> resource.equals(event.getResourceRef().getResource()))
        .filter(event -> resourceId.equals(event.getResourceRef().getResourceId()))
        .collect(Collectors.toList());
  }
}
