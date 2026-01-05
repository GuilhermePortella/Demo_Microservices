package com.msvsmm.approvalservice.repository;

import com.msvsmm.approvalservice.model.Approval;
import java.util.List;
import java.util.Optional;

public interface ApprovalRepository {
  Approval save(Approval approval);

  Optional<Approval> findById(String id);

  List<Approval> findByExpenseId(String expenseId);

  List<Approval> findAll();
}
