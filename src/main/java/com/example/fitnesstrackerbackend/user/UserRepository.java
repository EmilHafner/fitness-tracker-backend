package com.example.fitnesstrackerbackend.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
  /**
   * Find a user by username
   * @param username the username to search for
   * @return Optional containing the user if found, empty otherwise
   */
  Optional<User> findByUsername(String username);

}
