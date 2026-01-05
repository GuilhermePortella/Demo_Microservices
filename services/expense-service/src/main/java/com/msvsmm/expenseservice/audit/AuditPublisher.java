package com.msvsmm.expenseservice.audit;

import com.msvsmm.expenseservice.model.Expense;

public interface AuditPublisher {
  void recordCreated(Expense expense);

  void recordSubmitted(Expense expense);

  void recordStatusChange(Expense expense);
}
