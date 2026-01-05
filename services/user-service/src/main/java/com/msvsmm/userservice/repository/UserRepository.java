package com.msvsmm.userservice.repository;

import com.msvsmm.userservice.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
  User save(User user);

  Optional<User> findById(String id);

  List<User> findAll();

  List<User> findByManagerId(String managerId);

  List<User> findByCostCenterId(String costCenterId);

  List<User> findByManagerIdAndCostCenterId(String managerId, String costCenterId);
}
