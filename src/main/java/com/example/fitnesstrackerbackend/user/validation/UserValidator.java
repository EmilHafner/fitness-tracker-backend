package com.example.fitnesstrackerbackend.user.validation;

import com.example.fitnesstrackerbackend.auth.RegistrationRequest;
import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import com.example.fitnesstrackerbackend.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class UserValidator {

  private final UserRepository userRepository;

  /**
   * Validates a registration request
   *
   * @param registrationRequest the registration request to validate
   */
  public void validateForRegistration(
          RegistrationRequest registrationRequest) throws ValidationException, ConflictException {
    List<String> validationErrors = new ArrayList<>();
    List<String> conflictErrors = new ArrayList<>();


    if (registrationRequest.getUsername()
            == null
            || registrationRequest.getUsername().matches(" *")) {
      validationErrors.add("Username cannot be empty");
    }

    if (registrationRequest.getPassword()
            == null
            || registrationRequest.getPassword().isEmpty() || registrationRequest.getPassword().length() < 8) {
      validationErrors.add("Password must be at least 8 characters long");
    }

    if (registrationRequest.getFirstName()
            == null
            || registrationRequest.getFirstName().matches(" *")) {
      validationErrors.add("First name cannot be empty");
    }

    if (registrationRequest.getLastName()
            == null
            || registrationRequest.getLastName().matches(" *")) {
      validationErrors.add("Last name cannot be empty");
    }

    if (registrationRequest.getUsername() != null && userRepository.findByUsername(registrationRequest.getUsername().toLowerCase()).isPresent()) {
      conflictErrors.add("Username is already taken");
    }

    if (!conflictErrors.isEmpty()) {
      throw new ConflictException("Registration request conflicts with existing data", conflictErrors);
    }

    if (!validationErrors.isEmpty()) {
      throw new ValidationException("Validation of registration request failed", validationErrors);
    }

  }
}
