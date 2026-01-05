package com.msvsmm.expenseservice.integration;

import com.msvsmm.expenseservice.model.Expense;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class NoopApprovalClient implements ApprovalClient {
  @Override
  public String startApproval(Expense expense) {
    return UUID.randomUUID().toString();
  }
}
