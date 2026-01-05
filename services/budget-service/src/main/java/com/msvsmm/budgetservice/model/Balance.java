package com.msvsmm.budgetservice.model;

import java.math.BigDecimal;

public class Balance {
  private BigDecimal totalAmount;
  private BigDecimal reservedAmount;
  private BigDecimal consumedAmount;
  private BigDecimal availableAmount;

  public Balance() {
  }

  public Balance(
      BigDecimal totalAmount,
      BigDecimal reservedAmount,
      BigDecimal consumedAmount,
      BigDecimal availableAmount
  ) {
    this.totalAmount = totalAmount;
    this.reservedAmount = reservedAmount;
    this.consumedAmount = consumedAmount;
    this.availableAmount = availableAmount;
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

  public BigDecimal getAvailableAmount() {
    return availableAmount;
  }

  public void setAvailableAmount(BigDecimal availableAmount) {
    this.availableAmount = availableAmount;
  }
}
