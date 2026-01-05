package com.msvsmm.budgetservice.controller;

import com.msvsmm.budgetservice.dto.BudgetCheckRequest;
import com.msvsmm.budgetservice.dto.BudgetCheckResponse;
import com.msvsmm.budgetservice.model.Budget;
import com.msvsmm.budgetservice.model.CostCenter;
import com.msvsmm.budgetservice.service.BudgetService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BudgetController {
  private final BudgetService budgetService;

  public BudgetController(BudgetService budgetService) {
    this.budgetService = budgetService;
  }

  @PostMapping("/budgets/check")
  public BudgetCheckResponse check(@Valid @RequestBody BudgetCheckRequest request) {
    return budgetService.checkBudget(request);
  }

  @GetMapping("/budgets/{id}")
  public Budget getBudget(@PathVariable String id) {
    return budgetService.getBudget(id);
  }

  @GetMapping("/cost-centers/{id}")
  public CostCenter getCostCenter(@PathVariable String id) {
    return budgetService.getCostCenter(id);
  }
}
