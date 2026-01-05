package com.msvsmm.budgetservice.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Budget {
  private String id;
  private String costCenterId;
  private String currency;
  private BigDecimal totalAmount;
  private BigDecimal reservedAmount;
  private BigDecimal consumedAmount;
  private Instant createdAt;
  private Instant updatedAt;

  public Budget() {
  }

  public Budget(
      String id,
      String costCenterId,
      String currency,
      BigDecimal totalAmount,
      BigDecimal reservedAmount,
      BigDecimal consumedAmount,
      Instant createdAt,
      Instant updatedAt
  ) {
    this.id = id;
    this.costCenterId = costCenterId;
    this.currency = currency;
    this.totalAmount = totalAmount;
    this.reservedAmount = reservedAmount;
    this.consumedAmount = consumedAmount;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCostCenterId() {
    return costCenterId;
  }

  public void setCostCenterId(String costCenterId) {
    this.costCenterId = costCenterId;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public BigDecimal getReservedAmount() {
    return reservedAmount;
  }

  public void setReservedAmount(BigDecimal reservedAmount) {
    this.reservedAmount = reservedAmount;
  }

  public BigDecimal getConsumedAmount() {
    return consumedAmount;
  }

  public void setConsumedAmount(BigDecimal consumedAmount) {
    this.consumedAmount = consumedAmount;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }
}
