package com.example.fitnesstrackerbackend.controller;

import com.example.fitnesstrackerbackend.service.UserService;
import com.example.fitnesstrackerbackend.user.User;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminAccessController {

  private final UserService userService;

  @GetMapping("/all-users")
  public List<User> allUsers() {

    return userService.getAllUsers();
  }
}
