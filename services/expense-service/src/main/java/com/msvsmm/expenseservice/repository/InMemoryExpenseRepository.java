package com.msvsmm.expenseservice.repository;

import com.msvsmm.expenseservice.model.Expense;
import com.msvsmm.expenseservice.model.ExpenseStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryExpenseRepository implements ExpenseRepository {
  private final Map<String, Expense> store = new ConcurrentHashMap<>();

  @Override
  public Expense save(Expense expense) {
    store.put(expense.getId(), expense);
    return expense;
  }

  @Override
  public Optional<Expense> findById(String id) {
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public List<Expense> findAll() {
    return new ArrayList<>(store.values());
  }

  @Override
  public List<Expense> findByStatus(ExpenseStatus status) {
    return store.values()
        .stream()
        .filter(expense -> status == expense.getStatus())
        .collect(Collectors.toList());
  }

  @Override
  public List<Expense> findByOwnerId(String ownerId) {
    return store.values()
        .stream()
        .filter(expense -> ownerId.equals(expense.getOwnerId()))
        .collect(Collectors.toList());
  }

  @Override
  public List<Expense> findByOwnerIdAndStatus(String ownerId, ExpenseStatus status) {
    return store.values()
        .stream()
        .filter(expense -> ownerId.equals(expense.getOwnerId()))
        .filter(expense -> status == expense.getStatus())
        .collect(Collectors.toList());
  }
}
