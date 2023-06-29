package com.example.fitnesstrackerbackend.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_user")
public class User implements UserDetails {

  @Id
  @GeneratedValue
  private Integer id;
  private String firstName;
  private String lastName;
  @Column(unique = true)
  private String username;
  private String password;
  @Enumerated(EnumType.STRING)
  private Role role;

  @Override public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override public String getUsername() {
    return username;
  }

  @Override public boolean isAccountNonExpired() {
    return true;
  }

  @Override public boolean isAccountNonLocked() {
    return true;
  }

  @Override public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override public boolean isEnabled() {
    return true;
  }
}
