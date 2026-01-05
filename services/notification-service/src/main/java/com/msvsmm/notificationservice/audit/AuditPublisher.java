package com.msvsmm.notificationservice.audit;

import com.msvsmm.notificationservice.model.Notification;

public interface AuditPublisher {
  void recordSent(Notification notification);

  void recordFailed(Notification notification);
}
