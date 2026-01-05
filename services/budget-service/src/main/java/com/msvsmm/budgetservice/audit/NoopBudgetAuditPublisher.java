package com.msvsmm.budgetservice.audit;

import com.msvsmm.budgetservice.model.Budget;
import org.springframework.stereotype.Component;

@Component
public class NoopBudgetAuditPublisher implements BudgetAuditPublisher {
  @Override
  public void recordCheck(Budget budget, String reason) {
  }
}
