package com.example.fitnesstrackerbackend.service.validators;

import com.example.fitnesstrackerbackend.exception.NotFoundException;
import com.example.fitnesstrackerbackend.models.ExerciseEvent;
import com.example.fitnesstrackerbackend.models.Training;
import com.example.fitnesstrackerbackend.repository.ExerciseEventRepository;
import com.example.fitnesstrackerbackend.repository.TrainingsRepository;
import com.example.fitnesstrackerbackend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccessValidator {

  private final TrainingsRepository trainingsRepository;
  private final ExerciseEventRepository exerciseEventRepository;


  public void validateUserAccessToTraining(long trainingId) throws NotFoundException {
    Training training = trainingsRepository.getTrainingById(trainingId).orElseThrow(
            () -> new NotFoundException(String.format("Training with Id %s not found", trainingId)));

    validateUserAccessToTraining(training);

  }

  public void validateUserAccessToTraining(Training training) throws NotFoundException {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (!training.getUser().getId().equals(user.getId())) {
      throw new NotFoundException(String.format("Training with id %s not found for user with id %s", training.getId(), user.getId()));
    }
  }

  public void validateUserAccessToExerciseEvent(long exerciseEventId) throws NotFoundException {
    ExerciseEvent exerciseEvent = exerciseEventRepository.findById(exerciseEventId).orElseThrow(
            () -> new NotFoundException(String.format("ExerciseEvent with Id %s not found", exerciseEventId)));

    validateUserAccessToExerciseEvent(exerciseEvent);
  }

  public void validateUserAccessToExerciseEvent(ExerciseEvent exerciseEvent) throws NotFoundException {

    Training training = exerciseEvent.getTraining();

    validateUserAccessToTraining(training);
  }

}
