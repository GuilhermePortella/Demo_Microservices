package com.msvsmm.policyservice.repository;

import com.msvsmm.policyservice.model.Limit;
import com.msvsmm.policyservice.model.LimitType;
import com.msvsmm.policyservice.model.Policy;
import com.msvsmm.policyservice.model.PolicyRule;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPolicyRepository implements PolicyRepository {
  private final Map<String, Policy> store = new ConcurrentHashMap<>();

  public InMemoryPolicyRepository() {
    seedDefaults();
  }

  @Override
  public Policy save(Policy policy) {
    store.put(policy.getId(), policy);
    return policy;
  }

  @Override
  public Optional<Policy> findById(String id) {
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public List<Policy> findByArea(String area) {
    return store.values()
        .stream()
        .filter(policy -> area.equalsIgnoreCase(policy.getArea()))
        .collect(Collectors.toList());
  }

  @Override
  public List<Policy> findAll() {
    return new ArrayList<>(store.values());
  }

  private void seedDefaults() {
    if (!store.isEmpty()) {
      return;
    }

    List<Limit> mealLimits = new ArrayList<>();
    mealLimits.add(new Limit(LimitType.MAX_PER_ITEM, BigDecimal.valueOf(150), "BRL"));
    PolicyRule meals = new PolicyRule(UUID.randomUUID().toString(), "Meals", "MEAL", mealLimits);

    List<Limit> travelLimits = new ArrayList<>();
    travelLimits.add(new Limit(LimitType.MAX_PER_ITEM, BigDecimal.valueOf(1200), "BRL"));
    travelLimits.add(new Limit(LimitType.MAX_TOTAL, BigDecimal.valueOf(5000), "BRL"));
    PolicyRule travel = new PolicyRule(UUID.randomUUID().toString(), "Travel", "TRAVEL", travelLimits);

    List<PolicyRule> rules = new ArrayList<>();
    rules.add(meals);
    rules.add(travel);

    Policy policy = new Policy(
        UUID.randomUUID().toString(),
        "default",
        "Default policy",
        "Default spending policy",
        rules,
        Instant.now(),
        Instant.now()
    );
    store.put(policy.getId(), policy);
  }
}
