package com.msvsmm.budgetservice.repository;

import com.msvsmm.budgetservice.model.Budget;
import java.util.List;
import java.util.Optional;

public interface BudgetRepository {
  Budget save(Budget budget);

  Optional<Budget> findById(String id);

  Optional<Budget> findByCostCenterId(String costCenterId);

  List<Budget> findAll();
}
