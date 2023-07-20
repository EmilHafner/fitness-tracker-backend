package com.example.fitnesstrackerbackend.service.validators;


import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import com.example.fitnesstrackerbackend.models.Training;
import com.example.fitnesstrackerbackend.repository.TrainingsRepository;
import com.example.fitnesstrackerbackend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TrainingValidator {

  private final TrainingsRepository trainingsRepository;

  public void validateForStopTraining(Training training) throws ConflictException {

    List<String> conflictErrors = new ArrayList<>();

    if (training.getEndDateTime()
            != null) {
      conflictErrors.add("Training is already stopped");
    }

    if (conflictErrors.size()
            > 0) {
      throw new ConflictException("Update request conflicts with existing data", conflictErrors);
    }

  }

  public void validateForSaveTraining(Training training) throws ConflictException, ValidationException {
    List<String> validationErrors = new ArrayList<>();
    List<String> conflictErrors = new ArrayList<>();

    if (training.getId()
            != null) {
      conflictErrors.add("Training id must be null");
    }

    if (training.getStartDateTime()
            == null) {
      validationErrors.add("Start date time cannot be empty");
    }

    // Check if another training is currently active for the user
    if (trainingsRepository.findTrainingsByUser(training.getUser()).stream().anyMatch(t -> t.getEndDateTime()
            == null)) {
      conflictErrors.add("Another training is currently active for this user");
    }

    if (conflictErrors.size()
            > 0) {
      throw new ConflictException("Update request conflicts with existing data", conflictErrors);
    }

    if (validationErrors.size()
            > 0) {
      throw new ValidationException("Update request is invalid", validationErrors);
    }

  }
}
