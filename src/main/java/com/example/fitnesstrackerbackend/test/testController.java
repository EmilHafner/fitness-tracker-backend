package com.example.fitnesstrackerbackend.test;

import com.example.fitnesstrackerbackend.config.jwt.JwtService;
import com.example.fitnesstrackerbackend.service.UserService;
import com.example.fitnesstrackerbackend.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/test-controller")
public class testController {

  private final UserService userService;
  private final JwtService jwtService;

  @GetMapping
  public List<User> helloWorld() {
    return userService.getAllUsers();
  }

  @GetMapping("token")
  public String getClaims(@RequestHeader("Authorization") String token) {
    String jwt = token.substring(7);
    return jwtService.extractClaim(jwt, Claims::getId);
  }
}
