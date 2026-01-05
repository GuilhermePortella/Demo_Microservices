package com.msvsmm.notificationservice.controller;

import com.msvsmm.notificationservice.dto.CreateNotificationRequest;
import com.msvsmm.notificationservice.dto.CreateNotificationResponse;
import com.msvsmm.notificationservice.model.Notification;
import com.msvsmm.notificationservice.service.NotificationService;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
  private final NotificationService notificationService;

  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @PostMapping
  public ResponseEntity<CreateNotificationResponse> create(
      @Valid @RequestBody CreateNotificationRequest request
  ) {
    Notification notification = notificationService.createNotification(request);
    URI location = URI.create("/notifications/" + notification.getId());
    CreateNotificationResponse response = new CreateNotificationResponse(
        notification.getId(),
        notification.getStatus()
    );
    return ResponseEntity.created(location).body(response);
  }

  @GetMapping("/{id}")
  public Notification get(@PathVariable String id) {
    return notificationService.getNotification(id);
  }
}
