package com.example.fitnesstrackerbackend.controller;

import com.example.fitnesstrackerbackend.controller.dto.TrainingDto;
import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.NotFoundException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import com.example.fitnesstrackerbackend.models.ExerciseEvent;
import com.example.fitnesstrackerbackend.models.Training;
import com.example.fitnesstrackerbackend.service.TrainingsService;
import com.example.fitnesstrackerbackend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/training")
public class TrainingController {

  private final TrainingsService trainingsService;

  @GetMapping("/all-trainings")
  public List<Training> getAllTrainingsForCurrentUser() {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return trainingsService.getAllTrainingsForUser(user);
  }

  @GetMapping("/{trainingId}")
  public Optional<Training> getTrainingById(@PathVariable Long trainingId) throws NotFoundException {
    return trainingsService.getTrainingById(trainingId);
  }

  @PostMapping("/add-training")
  public Training addTraining(@RequestBody Training training) throws ValidationException, ConflictException {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    training.setUser(user);

    return trainingsService.saveTraining(training);
  }

  @PatchMapping("/stop-training/{trainingId}")
  public Training stopTraining(@PathVariable Long trainingId) throws ConflictException, NotFoundException {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return trainingsService.stopTrainingWithIdAndUser(trainingId, user);
  }

  @DeleteMapping("/delete-training/{trainingId}")
  public void deleteTraining(@PathVariable Long trainingId) throws NotFoundException {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    trainingsService.deleteTrainingWithIdAndUser(trainingId, user);
  }


  @GetMapping("/{trainingId}/exerciseEvents")
  public List<ExerciseEvent> getExercisesForTraining(@PathVariable Long trainingId) throws NotFoundException {
    return trainingsService.getExercisesForTraining(trainingId);
  }

  @PostMapping("/{trainingId}/exerciseEvents")
  public ExerciseEvent addExerciseEventToTraining(
          @PathVariable Long trainingId, @RequestBody ExerciseEvent exerciseEvent) throws NotFoundException, ConflictException, ValidationException {
    return trainingsService.addExerciseEventToTraining(trainingId,  exerciseEvent);
  }

}


