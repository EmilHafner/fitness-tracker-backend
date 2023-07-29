package com.example.fitnesstrackerbackend.service.validators;

import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import com.example.fitnesstrackerbackend.models.ExerciseType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExerciseTypeValidator {

  public void validateForSaveOrUpdate(ExerciseType exerciseType) throws ValidationException, ConflictException {
    List<String> validationErrors = new ArrayList<>();
    List<String> conflictErrors = new ArrayList<>();

    if (exerciseType.getName() == null || exerciseType.getName().isBlank() || exerciseType.getName().matches("\\s+.*")) {
      validationErrors.add("Name cannot be empty");
    }

    if (validationErrors.size() > 0) {
      throw new ValidationException("Validation errors", validationErrors);
    }

  }
}
