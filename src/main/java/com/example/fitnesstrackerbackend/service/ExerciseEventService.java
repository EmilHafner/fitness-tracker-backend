package com.example.fitnesstrackerbackend.service;

import com.example.fitnesstrackerbackend.exception.NotFoundException;
import com.example.fitnesstrackerbackend.models.ExerciseEvent;
import com.example.fitnesstrackerbackend.models.ExerciseType;
import com.example.fitnesstrackerbackend.models.TrainingsSet;
import com.example.fitnesstrackerbackend.repository.ExerciseEventRepository;
import com.example.fitnesstrackerbackend.repository.ExerciseTypeRepository;
import com.example.fitnesstrackerbackend.repository.TrainingsSetRepository;
import com.example.fitnesstrackerbackend.service.validators.AccessValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseEventService {


  private final ExerciseEventRepository exerciseEventRepository;
  private final TrainingsSetRepository trainingsSetRepository;
  private final AccessValidator accessValidator;
  private final ExerciseTypeRepository exerciseTypeRepository;

  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
  @PostAuthorize("returnObject?.training.user.id == authentication.principal.id")
  public ExerciseEvent getExerciseEventById(Long id) {
    return exerciseEventRepository.findById(id).orElse(null);
  }

  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN') and #exerciseEvent.training.user.id == authentication.principal.id")
  public ExerciseEvent update(ExerciseEvent exerciseEvent) {
    return exerciseEventRepository.save(exerciseEvent);
  }

  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN') and @exerciseEventRepository.findById(#id).orElse(null)?.training.user.id == authentication.principal.id")
  public long deleteById(long id) {
    exerciseEventRepository.deleteById(id);
    return id;
  }

  // Training Set endpoints
  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN') and @exerciseEventRepository.findById(#exerciseEventId).orElse(null)?.training.user.id == authentication.principal.id")
  public List<TrainingsSet> getSetsForExerciseEvent(Long exerciseEventId) throws NotFoundException {
    return exerciseEventRepository.findById(exerciseEventId).orElseThrow(
            () -> new NotFoundException(String.format("ExerciseEvent with Id %s not found", exerciseEventId))).getTrainingsSets();
  }

  @PreAuthorize("hasRole('ROLE_USER') and @exerciseEventRepository.findById(#exerciseEventId).orElse(null)?.training.user.id == authentication.principal.id")
  public TrainingsSet addSetToExerciseEvent(Long exerciseEventId, TrainingsSet trainingsSet) throws NotFoundException {
    ExerciseEvent exerciseEvent = exerciseEventRepository.findById(exerciseEventId).orElseThrow(
            () -> new NotFoundException(String.format("ExerciseEvent with Id %s not found", exerciseEventId)));

    accessValidator.validateAccessToExerciseEvent(exerciseEvent);

    trainingsSet.setExerciseEvent(exerciseEvent);
    trainingsSet.setOrderNumber(exerciseEvent.getTrainingsSets().size() + 1);

    return trainingsSetRepository.save(trainingsSet);
  }


  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN') and @exerciseEventRepository.findById(#exerciseEventId).orElse(null)?.training.user.id == authentication.principal.id")
  public ExerciseEvent updateExerciseTypeForExerciseEvent(Long exerciseEventId, Long exerciseTypeId) throws NotFoundException {

    ExerciseEvent exerciseEvent = exerciseEventRepository.findById(exerciseEventId).orElseThrow(
            () -> new NotFoundException(String.format("ExerciseEvent with Id %s not found", exerciseEventId)));

    ExerciseType exerciseType = exerciseTypeRepository.findById(exerciseTypeId).orElseThrow(
            () -> new NotFoundException(String.format("ExerciseType with Id %s not found", exerciseTypeId)));

    accessValidator.validateAccessToExerciseEvent(exerciseEvent);

    exerciseEvent.setExerciseType(exerciseType);

    return exerciseEventRepository.save(exerciseEvent);

  }
}
