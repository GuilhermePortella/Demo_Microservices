package com.msvsmm.policyservice.controller;

import com.msvsmm.policyservice.dto.PolicyValidationRequest;
import com.msvsmm.policyservice.dto.PolicyValidationResponse;
import com.msvsmm.policyservice.model.Policy;
import com.msvsmm.policyservice.service.PolicyService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/policies")
public class PolicyController {
  private final PolicyService policyService;

  public PolicyController(PolicyService policyService) {
    this.policyService = policyService;
  }

  @PostMapping("/validate")
  public PolicyValidationResponse validate(@Valid @RequestBody PolicyValidationRequest request) {
    return policyService.validate(request);
  }

  @GetMapping("/{id}")
  public Policy get(@PathVariable String id) {
    return policyService.getPolicy(id);
  }

  @GetMapping
  public List<Policy> list(@RequestParam(required = false) String area) {
    return policyService.listPolicies(area);
  }
}
