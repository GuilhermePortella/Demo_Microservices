package com.msvsmm.approvalservice.audit;

import com.msvsmm.approvalservice.model.Approval;
import com.msvsmm.approvalservice.model.ApproverDecision;
import org.springframework.stereotype.Component;

@Component
public class NoopAuditPublisher implements AuditPublisher {
  @Override
  public void recordApprovalCreated(Approval approval) {
  }

  @Override
  public void recordDecision(Approval approval, ApproverDecision decision) {
  }
}
