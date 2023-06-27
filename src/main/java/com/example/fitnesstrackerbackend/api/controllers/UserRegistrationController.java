package com.example.fitnesstrackerbackend.api.controllers;

import com.example.fitnesstrackerbackend.api.dto.UserRegistrationRequest;
import com.example.fitnesstrackerbackend.api.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class UserRegistrationController {

  @Autowired
  private UserRegistrationService userRegistrationService;

  @PostMapping
  public String register(@RequestBody UserRegistrationRequest request) {
    return userRegistrationService.register(request);
  }

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }
}
