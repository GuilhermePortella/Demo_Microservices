package com.msvsmm.expenseservice.integration;

import com.msvsmm.expenseservice.model.Expense;

public interface PolicyClient {
  PolicyCheckResult validate(Expense expense);
}
