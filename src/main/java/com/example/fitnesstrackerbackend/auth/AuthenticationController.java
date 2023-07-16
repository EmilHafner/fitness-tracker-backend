package com.example.fitnesstrackerbackend.auth;

import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequest request) throws ValidationException, ConflictException {
    return ResponseEntity.ok(authService.register(request));
  }

  @PostMapping("/register/admin")
  public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegistrationRequest request) throws ValidationException, ConflictException {
    return ResponseEntity.ok(authService.registerAdmin(request));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(authService.authenticate(request));
  }

}
