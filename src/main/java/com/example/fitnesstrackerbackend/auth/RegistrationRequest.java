package com.example.fitnesstrackerbackend.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
  private String firstName;
  private String lastName;
  private String username;
  private String password;
}
