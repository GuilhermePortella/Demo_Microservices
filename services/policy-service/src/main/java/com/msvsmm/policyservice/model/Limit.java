package com.msvsmm.policyservice.model;

import java.math.BigDecimal;

public class Limit {
  private LimitType type;
  private BigDecimal amount;
  private String currency;

  public Limit() {
  }

  public Limit(LimitType type, BigDecimal amount, String currency) {
    this.type = type;
    this.amount = amount;
    this.currency = currency;
  }

  public LimitType getType() {
    return type;
  }

  public void setType(LimitType type) {
    this.type = type;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
