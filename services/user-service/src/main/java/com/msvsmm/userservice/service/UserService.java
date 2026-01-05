package com.msvsmm.userservice.service;

import com.msvsmm.userservice.dto.UpdateUserRequest;
import com.msvsmm.userservice.model.User;
import com.msvsmm.userservice.repository.UserRepository;
import java.time.Instant;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public User getUser(String id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
  }

  public List<User> listUsers(String managerId, String costCenterId) {
    boolean hasManager = hasValue(managerId);
    boolean hasCostCenter = hasValue(costCenterId);

    if (hasManager && hasCostCenter) {
      return repository.findByManagerIdAndCostCenterId(managerId, costCenterId);
    }
    if (hasManager) {
      return repository.findByManagerId(managerId);
    }
    if (hasCostCenter) {
      return repository.findByCostCenterId(costCenterId);
    }
    return repository.findAll();
  }

  public User updateUser(String id, UpdateUserRequest request) {
    User user = getUser(id);
    boolean changed = false;

    if (request.getName() != null) {
      user.setName(request.getName());
      changed = true;
    }
    if (request.getEmail() != null) {
      user.setEmail(request.getEmail());
      changed = true;
    }
    if (request.getRoleId() != null) {
      user.setRoleId(request.getRoleId());
      changed = true;
    }
    if (request.getManagerId() != null) {
      user.setManagerId(request.getManagerId());
      changed = true;
    }
    if (request.getCostCenterId() != null) {
      user.setCostCenterId(request.getCostCenterId());
      changed = true;
    }
    if (request.getActive() != null) {
      user.setActive(request.getActive());
      changed = true;
    }

    if (changed) {
      user.setUpdatedAt(Instant.now());
      repository.save(user);
    }

    return user;
  }

  private boolean hasValue(String value) {
    return value != null && !value.isBlank();
  }
}
