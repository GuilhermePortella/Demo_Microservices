package com.msvsmm.expenseservice.audit;

import com.msvsmm.expenseservice.model.Expense;
import org.springframework.stereotype.Component;

@Component
public class NoopAuditPublisher implements AuditPublisher {
  @Override
  public void recordCreated(Expense expense) {
  }

  @Override
  public void recordSubmitted(Expense expense) {
  }

  @Override
  public void recordStatusChange(Expense expense) {
  }
}
