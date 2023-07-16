package com.example.fitnesstrackerbackend.auth;

import com.example.fitnesstrackerbackend.user.Role;

public record UserResponseDto(
        Long id,
        String firstName,
        String lastName,
        String username,
        Role role
) {
}
