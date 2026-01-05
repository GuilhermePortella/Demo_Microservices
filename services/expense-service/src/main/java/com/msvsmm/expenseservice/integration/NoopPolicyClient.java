package com.msvsmm.expenseservice.integration;

import com.msvsmm.expenseservice.model.Expense;
import org.springframework.stereotype.Component;

@Component
public class NoopPolicyClient implements PolicyClient {
  @Override
  public PolicyCheckResult validate(Expense expense) {
    return new PolicyCheckResult(true, "OK");
  }
}
