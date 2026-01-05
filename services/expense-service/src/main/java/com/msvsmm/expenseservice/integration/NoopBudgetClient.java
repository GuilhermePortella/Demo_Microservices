package com.msvsmm.expenseservice.integration;

import com.msvsmm.expenseservice.model.Expense;
import org.springframework.stereotype.Component;

@Component
public class NoopBudgetClient implements BudgetClient {
  @Override
  public BudgetCheckResult check(Expense expense) {
    return new BudgetCheckResult(true, "OK");
  }
}
