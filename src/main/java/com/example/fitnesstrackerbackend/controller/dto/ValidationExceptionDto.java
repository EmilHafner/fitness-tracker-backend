package com.example.fitnesstrackerbackend.controller.dto;

import java.util.List;

/**
 * DTO for validation exceptions.
 * @see com.example.fitnesstrackerbackend.exception.ValidationException
 * @param message the error message
 * @param errors the list of errors that failed when validating the piece of data in question
 */
public record ValidationExceptionDto (
        String message,
        List<String> errors
){}