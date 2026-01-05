package com.msvsmm.expenseservice.integration;

import org.springframework.stereotype.Component;

@Component
public class NoopUserClient implements UserClient {
  @Override
  public boolean userExists(String userId) {
    return true;
  }
}
