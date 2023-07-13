package com.example.fitnesstrackerbackend.controller.dto;

public record TrainingDto(
        // Start date and time of the training.
        String startDateTime,
        // Duration of the training.
        String duration
) {
}
