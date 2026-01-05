package com.msvsmm.auditservice.repository;

import com.msvsmm.auditservice.model.AuditEvent;
import java.util.List;
import java.util.Optional;

public interface AuditEventRepository {
  AuditEvent save(AuditEvent event);

  Optional<AuditEvent> findById(String id);

  List<AuditEvent> findAll();

  List<AuditEvent> findByResource(String resource);

  List<AuditEvent> findByResourceId(String resourceId);

  List<AuditEvent> findByResourceAndResourceId(String resource, String resourceId);
}
