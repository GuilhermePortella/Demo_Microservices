package com.msvsmm.notificationservice.integration;

import com.msvsmm.notificationservice.model.Channel;
import org.springframework.stereotype.Component;

@Component
public class NoopUserContactClient implements UserContactClient {
  @Override
  public String resolveContact(String userId, Channel channel) {
    if (channel == Channel.SLACK) {
      return "slack:" + userId;
    }
    return userId + "@example.com";
  }
}
