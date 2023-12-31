package com.example.fitnesstrackerbackend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  /**
   * Find a user by username
   * @param username the username to search for
   * @return Optional containing the user if found, empty otherwise
   */
  Optional<User> findByUsernameAllIgnoreCase(String username);
}
