package com.msvsmm.notificationservice.service;

import com.msvsmm.notificationservice.audit.AuditPublisher;
import com.msvsmm.notificationservice.delivery.DeliveryResult;
import com.msvsmm.notificationservice.delivery.NotificationSender;
import com.msvsmm.notificationservice.dto.CreateNotificationRequest;
import com.msvsmm.notificationservice.integration.UserContactClient;
import com.msvsmm.notificationservice.model.DeliveryStatus;
import com.msvsmm.notificationservice.model.Notification;
import com.msvsmm.notificationservice.repository.NotificationRepository;
import java.time.Instant;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class NotificationService {
  private final NotificationRepository repository;
  private final UserContactClient userContactClient;
  private final NotificationSender notificationSender;
  private final AuditPublisher auditPublisher;

  public NotificationService(
      NotificationRepository repository,
      UserContactClient userContactClient,
      NotificationSender notificationSender,
      AuditPublisher auditPublisher
  ) {
    this.repository = repository;
    this.userContactClient = userContactClient;
    this.notificationSender = notificationSender;
    this.auditPublisher = auditPublisher;
  }

  public Notification createNotification(CreateNotificationRequest request) {
    String id = UUID.randomUUID().toString();
    Instant now = Instant.now();
    String address = hasValue(request.getAddress())
        ? request.getAddress()
        : userContactClient.resolveContact(request.getRecipientId(), request.getChannel());

    Notification notification = new Notification(
        id,
        request.getRecipientId(),
        request.getChannel(),
        address,
        request.getMessage(),
        DeliveryStatus.PENDING,
        null,
        now,
        now,
        null
    );

    if (!hasValue(address)) {
      notification.setStatus(DeliveryStatus.FAILED);
      notification.setErrorMessage("Address not found");
      notification.setUpdatedAt(Instant.now());
      repository.save(notification);
      auditPublisher.recordFailed(notification);
      return notification;
    }

    DeliveryResult result = notificationSender.send(notification);
    if (result.isSuccess()) {
      notification.setStatus(DeliveryStatus.SENT);
      notification.setSentAt(Instant.now());
      auditPublisher.recordSent(notification);
    } else {
      notification.setStatus(DeliveryStatus.FAILED);
      notification.setErrorMessage(result.getErrorMessage());
      auditPublisher.recordFailed(notification);
    }

    notification.setUpdatedAt(Instant.now());
    repository.save(notification);
    return notification;
  }

  public Notification getNotification(String id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Notification not found"));
  }

  private boolean hasValue(String value) {
    return value != null && !value.isBlank();
  }
}
