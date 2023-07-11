package com.example.fitnesstrackerbackend.controller.dto;

import java.util.List;

public record ConflictExceptionDto(
        String message,
        List<String> errors
) {
}
