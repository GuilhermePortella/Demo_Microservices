package com.msvsmm.notificationservice.delivery;

import com.msvsmm.notificationservice.model.Notification;

public interface NotificationSender {
  DeliveryResult send(Notification notification);
}
