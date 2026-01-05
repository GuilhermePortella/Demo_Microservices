package com.msvsmm.budgetservice.repository;

import com.msvsmm.budgetservice.model.CostCenter;
import java.util.List;
import java.util.Optional;

public interface CostCenterRepository {
  CostCenter save(CostCenter costCenter);

  Optional<CostCenter> findById(String id);

  List<CostCenter> findAll();
}
