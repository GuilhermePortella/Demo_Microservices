package com.msvsmm.notificationservice.audit;

import com.msvsmm.notificationservice.model.Notification;
import org.springframework.stereotype.Component;

@Component
public class NoopAuditPublisher implements AuditPublisher {
  @Override
  public void recordSent(Notification notification) {
  }

  @Override
  public void recordFailed(Notification notification) {
  }
}
