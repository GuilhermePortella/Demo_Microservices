package com.msvsmm.approvalservice.repository;

import com.msvsmm.approvalservice.model.Approval;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryApprovalRepository implements ApprovalRepository {
  private final Map<String, Approval> store = new ConcurrentHashMap<>();

  @Override
  public Approval save(Approval approval) {
    store.put(approval.getId(), approval);
    return approval;
  }

  @Override
  public Optional<Approval> findById(String id) {
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public List<Approval> findByExpenseId(String expenseId) {
    return store.values()
        .stream()
        .filter(approval -> expenseId.equals(approval.getExpenseId()))
        .collect(Collectors.toList());
  }

  @Override
  public List<Approval> findAll() {
    return new ArrayList<>(store.values());
  }
}
