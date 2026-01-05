package com.msvsmm.budgetservice.audit;

import com.msvsmm.budgetservice.model.Budget;

public interface BudgetAuditPublisher {
  void recordCheck(Budget budget, String reason);
}
