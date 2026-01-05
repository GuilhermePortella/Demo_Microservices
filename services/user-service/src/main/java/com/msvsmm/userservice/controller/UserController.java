package com.msvsmm.userservice.controller;

import com.msvsmm.userservice.dto.UpdateUserRequest;
import com.msvsmm.userservice.model.User;
import com.msvsmm.userservice.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public User get(@PathVariable String id) {
    return userService.getUser(id);
  }

  @GetMapping
  public List<User> list(
      @RequestParam(required = false) String managerId,
      @RequestParam(required = false) String costCenterId
  ) {
    return userService.listUsers(managerId, costCenterId);
  }

  @PatchMapping("/{id}")
  public User update(
      @PathVariable String id,
      @Valid @RequestBody UpdateUserRequest request
  ) {
    return userService.updateUser(id, request);
  }
}
