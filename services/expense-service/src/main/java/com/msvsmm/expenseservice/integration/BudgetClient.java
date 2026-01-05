package com.msvsmm.expenseservice.integration;

import com.msvsmm.expenseservice.model.Expense;

public interface BudgetClient {
  BudgetCheckResult check(Expense expense);
}
