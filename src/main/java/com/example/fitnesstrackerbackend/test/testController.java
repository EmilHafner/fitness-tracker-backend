package com.example.fitnesstrackerbackend.test;

import com.example.fitnesstrackerbackend.service.UserService;
import com.example.fitnesstrackerbackend.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test-controller")
public class testController {

  UserService userService;

  @GetMapping
  public List<User> helloWorld() {
    return userService.getAllUsers();
  }
}
