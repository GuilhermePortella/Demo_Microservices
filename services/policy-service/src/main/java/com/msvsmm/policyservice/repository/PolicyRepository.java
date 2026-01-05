package com.msvsmm.policyservice.repository;

import com.msvsmm.policyservice.model.Policy;
import java.util.List;
import java.util.Optional;

public interface PolicyRepository {
  Policy save(Policy policy);

  Optional<Policy> findById(String id);

  List<Policy> findByArea(String area);

  List<Policy> findAll();
}
