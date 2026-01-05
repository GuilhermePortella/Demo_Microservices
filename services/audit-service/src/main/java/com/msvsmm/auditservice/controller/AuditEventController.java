package com.msvsmm.auditservice.controller;

import com.msvsmm.auditservice.dto.CreateAuditEventRequest;
import com.msvsmm.auditservice.dto.CreateAuditEventResponse;
import com.msvsmm.auditservice.model.AuditEvent;
import com.msvsmm.auditservice.service.AuditEventService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audit/events")
public class AuditEventController {
  private final AuditEventService service;

  public AuditEventController(AuditEventService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<CreateAuditEventResponse> create(
      @Valid @RequestBody CreateAuditEventRequest request
  ) {
    AuditEvent event = service.createEvent(request);
    URI location = URI.create("/audit/events/" + event.getId());
    CreateAuditEventResponse response = new CreateAuditEventResponse(
        event.getId(),
        event.getCreatedAt()
    );
    return ResponseEntity.created(location).body(response);
  }

  @GetMapping("/{id}")
  public AuditEvent get(@PathVariable String id) {
    return service.getEvent(id);
  }

  @GetMapping
  public List<AuditEvent> list(
      @RequestParam(required = false) String resource,
      @RequestParam(required = false) String resourceId
  ) {
    return service.listEvents(resource, resourceId);
  }
}
