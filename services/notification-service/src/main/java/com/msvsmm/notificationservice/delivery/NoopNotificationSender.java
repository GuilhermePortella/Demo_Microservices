package com.msvsmm.notificationservice.delivery;

import com.msvsmm.notificationservice.model.Notification;
import org.springframework.stereotype.Component;

@Component
public class NoopNotificationSender implements NotificationSender {
  @Override
  public DeliveryResult send(Notification notification) {
    return new DeliveryResult(true, null);
  }
}
