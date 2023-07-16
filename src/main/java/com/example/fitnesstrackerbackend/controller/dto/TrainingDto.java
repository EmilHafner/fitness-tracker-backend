package com.example.fitnesstrackerbackend.controller.dto;


import java.util.Date;

public record TrainingDto(
        Long id,
        Long userId,
        Date startDateTime,
        Date endDateTime
) {
}
