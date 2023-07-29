package com.example.fitnesstrackerbackend.service;

import com.example.fitnesstrackerbackend.user.User;
import com.example.fitnesstrackerbackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  /**
   * Get all registered Users and their roles.
   * @return A list of all registered Users.
   */
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }



}
