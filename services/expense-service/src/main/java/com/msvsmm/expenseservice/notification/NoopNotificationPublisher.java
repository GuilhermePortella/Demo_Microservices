package com.msvsmm.expenseservice.notification;

import com.msvsmm.expenseservice.model.Expense;
import org.springframework.stereotype.Component;

@Component
public class NoopNotificationPublisher implements NotificationPublisher {
  @Override
  public void notifyCreated(Expense expense) {
  }

  @Override
  public void notifySubmitted(Expense expense) {
  }

  @Override
  public void notifyStatusChange(Expense expense) {
  }
}
