package com.msvsmm.approvalservice.audit;

import com.msvsmm.approvalservice.model.Approval;
import com.msvsmm.approvalservice.model.ApproverDecision;

public interface AuditPublisher {
  void recordApprovalCreated(Approval approval);

  void recordDecision(Approval approval, ApproverDecision decision);
}
