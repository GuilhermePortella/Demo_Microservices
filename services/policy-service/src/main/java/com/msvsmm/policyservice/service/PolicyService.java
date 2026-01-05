package com.msvsmm.policyservice.service;

import com.msvsmm.policyservice.dto.ExpenseItemDto;
import com.msvsmm.policyservice.dto.PolicyValidationRequest;
import com.msvsmm.policyservice.dto.PolicyValidationResponse;
import com.msvsmm.policyservice.model.Limit;
import com.msvsmm.policyservice.model.LimitType;
import com.msvsmm.policyservice.model.Policy;
import com.msvsmm.policyservice.model.PolicyRule;
import com.msvsmm.policyservice.repository.PolicyRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PolicyService {
  private final PolicyRepository repository;

  public PolicyService(PolicyRepository repository) {
    this.repository = repository;
  }

  public PolicyValidationResponse validate(PolicyValidationRequest request) {
    List<Policy> policies = repository.findByArea(request.getArea());
    if (policies.isEmpty()) {
      return new PolicyValidationResponse(false, "Policy not found");
    }

    Policy policy = policies.get(0);
    for (ExpenseItemDto item : safeItems(request)) {
      PolicyRule rule = findRule(policy, item.getCategory());
      if (rule == null) {
        return new PolicyValidationResponse(false, "No rule for category: " + item.getCategory());
      }
      String currency = request.getCurrency();
      PolicyValidationResponse violation = checkLimits(rule, item, currency);
      if (!violation.isAllowed()) {
        return violation;
      }
    }

    return new PolicyValidationResponse(true, "OK");
  }

  public Policy getPolicy(String id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Policy not found"));
  }

  public List<Policy> listPolicies(String area) {
    if (hasValue(area)) {
      return repository.findByArea(area);
    }
    return repository.findAll();
  }

  private List<ExpenseItemDto> safeItems(PolicyValidationRequest request) {
    return request.getItems() == null ? List.of() : request.getItems();
  }

  private PolicyRule findRule(Policy policy, String category) {
    if (category == null) {
      return null;
    }
    for (PolicyRule rule : policy.getRules()) {
      if (category.equalsIgnoreCase(rule.getCategory())) {
        return rule;
      }
    }
    return null;
  }

  private PolicyValidationResponse checkLimits(PolicyRule rule, ExpenseItemDto item, String currency) {
    BigDecimal amount = item.getAmount();
    for (Limit limit : rule.getLimits()) {
      if (!currency.equalsIgnoreCase(limit.getCurrency())) {
        continue;
      }
      if (limit.getType() == LimitType.MAX_PER_ITEM
          && amount.compareTo(limit.getAmount()) > 0) {
        return new PolicyValidationResponse(false, "Item exceeds limit for " + rule.getName());
      }
    }
    return new PolicyValidationResponse(true, "OK");
  }

  private boolean hasValue(String value) {
    return value != null && !value.isBlank();
  }
}
