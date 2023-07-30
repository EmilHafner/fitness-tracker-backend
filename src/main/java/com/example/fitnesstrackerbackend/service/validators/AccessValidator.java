package com.example.fitnesstrackerbackend.service.validators;

import com.example.fitnesstrackerbackend.exception.NotFoundException;
import com.example.fitnesstrackerbackend.models.ExerciseEvent;
import com.example.fitnesstrackerbackend.models.Training;
import com.example.fitnesstrackerbackend.models.TrainingsSet;
import com.example.fitnesstrackerbackend.repository.ExerciseEventRepository;
import com.example.fitnesstrackerbackend.repository.TrainingsRepository;
import com.example.fitnesstrackerbackend.repository.TrainingsSetRepository;
import com.example.fitnesstrackerbackend.service.TrainingsSetService;
import com.example.fitnesstrackerbackend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccessValidator {

  private final TrainingsRepository trainingsRepository;
  private final ExerciseEventRepository exerciseEventRepository;
  private final TrainingsSetRepository trainingsSetRepository;


  public void validateAccessToTraining(long trainingId) throws NotFoundException {
    Training training = trainingsRepository.getTrainingById(trainingId).orElseThrow(
            () -> new NotFoundException(String.format("Training with Id %s not found", trainingId)));

    validateAccessToTraining(training);

  }

  public void validateAccessToTraining(Training training) throws NotFoundException {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (!training.getUser().getId().equals(user.getId())) {
      throw new NotFoundException(String.format("Training with id %s not found for user with id %s", training.getId(), user.getId()));
    }
  }

  public void validateAccessToExerciseEvent(long exerciseEventId) throws NotFoundException {
    ExerciseEvent exerciseEvent = exerciseEventRepository.findById(exerciseEventId).orElseThrow(
            () -> new NotFoundException(String.format("ExerciseEvent with Id %s not found", exerciseEventId)));

    validateAccessToExerciseEvent(exerciseEvent);
  }

  public void validateAccessToExerciseEvent(ExerciseEvent exerciseEvent) throws NotFoundException {

    Training training = exerciseEvent.getTraining();

    validateAccessToTraining(training);
  }

  public void validateAccessToTrainingsSet(Long trainingsSetId) throws NotFoundException {
    TrainingsSet trainingsSet = trainingsSetRepository.findById(trainingsSetId).orElseThrow(
            () -> new NotFoundException(String.format("TrainingsSet with Id %s not found", trainingsSetId)));

    validateAccessToTrainingsSet(trainingsSet);
  }

  public void validateAccessToTrainingsSet(TrainingsSet trainingsSet) throws NotFoundException {
    ExerciseEvent exerciseEvent = trainingsSet.getExerciseEvent();

    validateAccessToExerciseEvent(exerciseEvent);
  }


}
