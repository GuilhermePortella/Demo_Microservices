package com.msvsmm.budgetservice.repository;

import com.msvsmm.budgetservice.model.CostCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCostCenterRepository implements CostCenterRepository {
  private final Map<String, CostCenter> store = new ConcurrentHashMap<>();

  @Override
  public CostCenter save(CostCenter costCenter) {
    store.put(costCenter.getId(), costCenter);
    return costCenter;
  }

  @Override
  public Optional<CostCenter> findById(String id) {
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public List<CostCenter> findAll() {
    return new ArrayList<>(store.values());
  }
}
