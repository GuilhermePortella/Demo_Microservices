package com.msvsmm.notificationservice.integration;

import com.msvsmm.notificationservice.model.Channel;

public interface UserContactClient {
  String resolveContact(String userId, Channel channel);
}
