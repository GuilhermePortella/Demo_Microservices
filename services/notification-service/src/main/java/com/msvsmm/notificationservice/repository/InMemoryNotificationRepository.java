package com.msvsmm.notificationservice.repository;

import com.msvsmm.notificationservice.model.Notification;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryNotificationRepository implements NotificationRepository {
  private final Map<String, Notification> store = new ConcurrentHashMap<>();

  @Override
  public Notification save(Notification notification) {
    store.put(notification.getId(), notification);
    return notification;
  }

  @Override
  public Optional<Notification> findById(String id) {
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public List<Notification> findAll() {
    return new ArrayList<>(store.values());
  }
}
