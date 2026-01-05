package com.msvsmm.expenseservice.repository;

import com.msvsmm.expenseservice.model.Expense;
import com.msvsmm.expenseservice.model.ExpenseStatus;
import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {
  Expense save(Expense expense);

  Optional<Expense> findById(String id);

  List<Expense> findAll();

  List<Expense> findByStatus(ExpenseStatus status);

  List<Expense> findByOwnerId(String ownerId);

  List<Expense> findByOwnerIdAndStatus(String ownerId, ExpenseStatus status);
}
