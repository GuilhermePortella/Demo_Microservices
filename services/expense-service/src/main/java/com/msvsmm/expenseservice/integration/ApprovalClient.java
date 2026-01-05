package com.msvsmm.expenseservice.integration;

import com.msvsmm.expenseservice.model.Expense;

public interface ApprovalClient {
  String startApproval(Expense expense);
}
