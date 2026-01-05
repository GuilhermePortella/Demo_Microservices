package com.msvsmm.expenseservice.controller;

import com.msvsmm.expenseservice.dto.CreateExpenseRequest;
import com.msvsmm.expenseservice.dto.CreateExpenseResponse;
import com.msvsmm.expenseservice.dto.UpdateExpenseRequest;
import com.msvsmm.expenseservice.model.Expense;
import com.msvsmm.expenseservice.model.ExpenseStatus;
import com.msvsmm.expenseservice.service.ExpenseService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
  private final ExpenseService expenseService;

  public ExpenseController(ExpenseService expenseService) {
    this.expenseService = expenseService;
  }

  @PostMapping
  public ResponseEntity<CreateExpenseResponse> create(
      @Valid @RequestBody CreateExpenseRequest request
  ) {
    Expense expense = expenseService.createExpense(request);
    URI location = URI.create("/expenses/" + expense.getId());
    CreateExpenseResponse response = new CreateExpenseResponse(
        expense.getId(),
        expense.getStatus()
    );
    return ResponseEntity.created(location).body(response);
  }

  @GetMapping("/{id}")
  public Expense get(@PathVariable String id) {
    return expenseService.getExpense(id);
  }

  @GetMapping
  public List<Expense> list(
      @RequestParam(required = false) ExpenseStatus status,
      @RequestParam(required = false) String ownerId
  ) {
    return expenseService.listExpenses(status, ownerId);
  }

  @PatchMapping("/{id}")
  public Expense update(
      @PathVariable String id,
      @Valid @RequestBody UpdateExpenseRequest request
  ) {
    return expenseService.updateExpense(id, request);
  }
}
