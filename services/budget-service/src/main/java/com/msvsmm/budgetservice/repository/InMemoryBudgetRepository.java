package com.msvsmm.budgetservice.repository;

import com.msvsmm.budgetservice.model.Budget;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBudgetRepository implements BudgetRepository {
  private final Map<String, Budget> store = new ConcurrentHashMap<>();

  @Override
  public Budget save(Budget budget) {
    store.put(budget.getId(), budget);
    return budget;
  }

  @Override
  public Optional<Budget> findById(String id) {
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public Optional<Budget> findByCostCenterId(String costCenterId) {
    return store.values()
        .stream()
        .filter(budget -> costCenterId.equals(budget.getCostCenterId()))
        .findFirst();
  }

  @Override
  public List<Budget> findAll() {
    return new ArrayList<>(store.values());
  }
}
