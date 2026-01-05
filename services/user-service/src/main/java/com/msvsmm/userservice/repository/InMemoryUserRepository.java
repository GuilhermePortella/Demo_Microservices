package com.msvsmm.userservice.repository;

import com.msvsmm.userservice.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUserRepository implements UserRepository {
  private final Map<String, User> store = new ConcurrentHashMap<>();

  @Override
  public User save(User user) {
    store.put(user.getId(), user);
    return user;
  }

  @Override
  public Optional<User> findById(String id) {
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public List<User> findAll() {
    return new ArrayList<>(store.values());
  }

  @Override
  public List<User> findByManagerId(String managerId) {
    return store.values()
        .stream()
        .filter(user -> managerId.equals(user.getManagerId()))
        .collect(Collectors.toList());
  }

  @Override
  public List<User> findByCostCenterId(String costCenterId) {
    return store.values()
        .stream()
        .filter(user -> costCenterId.equals(user.getCostCenterId()))
        .collect(Collectors.toList());
  }

  @Override
  public List<User> findByManagerIdAndCostCenterId(String managerId, String costCenterId) {
    return store.values()
        .stream()
        .filter(user -> managerId.equals(user.getManagerId()))
        .filter(user -> costCenterId.equals(user.getCostCenterId()))
        .collect(Collectors.toList());
  }
}
