package com.example.fitnesstrackerbackend.api.service;

import com.example.fitnesstrackerbackend.api.dto.UserRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
  public String register(UserRegistrationRequest request) {
    return "works";
  }
}
