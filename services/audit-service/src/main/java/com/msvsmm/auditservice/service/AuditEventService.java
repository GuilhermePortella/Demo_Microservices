package com.msvsmm.auditservice.service;

import com.msvsmm.auditservice.dto.ActorDto;
import com.msvsmm.auditservice.dto.CreateAuditEventRequest;
import com.msvsmm.auditservice.model.Actor;
import com.msvsmm.auditservice.model.AuditEvent;
import com.msvsmm.auditservice.model.ResourceRef;
import com.msvsmm.auditservice.repository.AuditEventRepository;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuditEventService {
  private final AuditEventRepository repository;

  public AuditEventService(AuditEventRepository repository) {
    this.repository = repository;
  }

  public AuditEvent createEvent(CreateAuditEventRequest request) {
    String id = UUID.randomUUID().toString();
    Instant now = Instant.now();
    ResourceRef resourceRef = new ResourceRef(request.getResource(), request.getResourceId());
    Actor actor = toActor(request.getActor());
    AuditEvent event = new AuditEvent(
        id,
        resourceRef,
        actor,
        request.getAction(),
        request.getPayload(),
        now
    );
    repository.save(event);
    return event;
  }

  public AuditEvent getEvent(String id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Audit event not found"));
  }

  public List<AuditEvent> listEvents(String resource, String resourceId) {
    boolean hasResource = hasValue(resource);
    boolean hasResourceId = hasValue(resourceId);

    if (hasResource && hasResourceId) {
      return repository.findByResourceAndResourceId(resource, resourceId);
    }
    if (hasResource) {
      return repository.findByResource(resource);
    }
    if (hasResourceId) {
      return repository.findByResourceId(resourceId);
    }
    return repository.findAll();
  }

  private Actor toActor(ActorDto dto) {
    return new Actor(dto.getId(), dto.getName(), dto.getType());
  }

  private boolean hasValue(String value) {
    return value != null && !value.isBlank();
  }
}
