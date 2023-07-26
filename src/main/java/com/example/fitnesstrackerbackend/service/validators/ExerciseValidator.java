package com.example.fitnesstrackerbackend.service.validators;

import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import com.example.fitnesstrackerbackend.models.Exercise;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExerciseValidator {

  public void validateForSaveOrUpdate(Exercise exercise) throws ValidationException, ConflictException {
    List<String> validationErrors = new ArrayList<>();
    List<String> conflictErrors = new ArrayList<>();

    if (exercise.getName() == null || exercise.getName().isBlank() || exercise.getName().matches("\\s+.*")) {
      validationErrors.add("Name cannot be empty");
    }

    if (validationErrors.size() > 0) {
      throw new ValidationException("Validation errors", validationErrors);
    }

  }
}
