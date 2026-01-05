package com.msvsmm.approvalservice.controller;

import com.msvsmm.approvalservice.dto.CreateApprovalRequest;
import com.msvsmm.approvalservice.dto.CreateApprovalResponse;
import com.msvsmm.approvalservice.dto.DecisionRequest;
import com.msvsmm.approvalservice.model.Approval;
import com.msvsmm.approvalservice.service.ApprovalService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/approvals")
public class ApprovalController {
  private final ApprovalService approvalService;

  public ApprovalController(ApprovalService approvalService) {
    this.approvalService = approvalService;
  }

  @PostMapping
  public ResponseEntity<CreateApprovalResponse> create(
      @Valid @RequestBody CreateApprovalRequest request
  ) {
    Approval approval = approvalService.createApproval(request);
    URI location = URI.create("/approvals/" + approval.getId());
    CreateApprovalResponse response = new CreateApprovalResponse(
        approval.getId(),
        approval.getStatus()
    );
    return ResponseEntity.created(location).body(response);
  }

  @GetMapping("/{id}")
  public Approval get(@PathVariable String id) {
    return approvalService.getApproval(id);
  }

  @GetMapping
  public List<Approval> list(@RequestParam(required = false) String expenseId) {
    return approvalService.getApprovals(expenseId);
  }

  @PostMapping("/{id}/decisions")
  public Approval decide(
      @PathVariable String id,
      @Valid @RequestBody DecisionRequest request
  ) {
    return approvalService.recordDecision(id, request);
  }
}
