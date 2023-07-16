package com.example.fitnesstrackerbackend.auth;

import com.example.fitnesstrackerbackend.config.jwt.JwtService;
import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import com.example.fitnesstrackerbackend.user.Role;
import com.example.fitnesstrackerbackend.user.User;
import com.example.fitnesstrackerbackend.user.UserRepository;
import com.example.fitnesstrackerbackend.user.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final UserValidator userValidator;

  public AuthenticationResponse register(RegistrationRequest request) throws ValidationException, ConflictException {

    userValidator.validateForRegistration(request);

    var user = User.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .username(request.getUsername().toLowerCase())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
    var savedUser = userRepository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .user(mapToDto(savedUser))
            .token(jwtToken)
            .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
            )
    );
    var user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", request.getUsername())));
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .user(mapToDto(user))
            .token(jwtToken)
            .build();  }

  public AuthenticationResponse registerAdmin(RegistrationRequest request) throws ValidationException, ConflictException {
    userValidator.validateForRegistration(request);

    var user = User.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .username(request.getUsername().toLowerCase())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.ADMIN)
            .build();
    var savedUser = userRepository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .user(mapToDto(savedUser))
            .token(jwtToken)
            .build();
  }

  private UserResponseDto mapToDto(User user) {
    return new UserResponseDto(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getUsername(),
            user.getRole()
    );
  }
}


