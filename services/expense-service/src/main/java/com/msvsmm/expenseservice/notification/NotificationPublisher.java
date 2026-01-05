package com.msvsmm.expenseservice.notification;

import com.msvsmm.expenseservice.model.Expense;

public interface NotificationPublisher {
  void notifyCreated(Expense expense);

  void notifySubmitted(Expense expense);

  void notifyStatusChange(Expense expense);
}
