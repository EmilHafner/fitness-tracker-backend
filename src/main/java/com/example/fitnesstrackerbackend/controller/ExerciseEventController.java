package com.example.fitnesstrackerbackend.controller;

import com.example.fitnesstrackerbackend.exception.NotFoundException;
import com.example.fitnesstrackerbackend.models.ExerciseEvent;
import com.example.fitnesstrackerbackend.models.ExerciseType;
import com.example.fitnesstrackerbackend.models.TrainingsSet;
import com.example.fitnesstrackerbackend.service.ExerciseEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exerciseEvents")
public class ExerciseEventController {

  private final ExerciseEventService exerciseEventService;

  @GetMapping("/{exerciseEventId}")
  public ExerciseEvent getExerciseEventById(@PathVariable Long exerciseEventId) {
    return exerciseEventService.getExerciseEventById(exerciseEventId);
  }

  @PutMapping("/{exerciseEventId}")
  public ExerciseEvent updateExerciseEvent(@PathVariable Long exerciseEventId,
                                           @RequestBody ExerciseEvent exerciseEvent) {
    exerciseEvent.setId(exerciseEventId);
    return exerciseEventService.update(exerciseEvent);
  }

  @DeleteMapping("/{exerciseEventId}")
  public Long deleteExerciseEventById(@PathVariable Long exerciseEventId) {
    return exerciseEventService.deleteById(exerciseEventId);
  }

  // --- Endpoints for Sets ---

  @GetMapping("/{exerciseEventId}/sets")
  public List<TrainingsSet> getSetsForExerciseEvent(@PathVariable Long exerciseEventId) throws NotFoundException {
    return exerciseEventService.getSetsForExerciseEvent(exerciseEventId);
  }

  @PostMapping("/{exerciseEventId}/sets")
  public TrainingsSet addSetToExerciseEvent(@PathVariable Long exerciseEventId,
                                            @RequestBody TrainingsSet trainingsSet) throws NotFoundException {


    return exerciseEventService.addSetToExerciseEvent(exerciseEventId, trainingsSet);
  }

  // --- Endpoints for ExerciseType ---
  @PutMapping("/{exerciseEventId}/exerciseType/{exerciseTypeId}")
    public ExerciseEvent updateExerciseTypeForExerciseEvent(@PathVariable Long exerciseEventId,
                                                            @PathVariable Long exerciseTypeId) throws NotFoundException {
        return exerciseEventService.updateExerciseTypeForExerciseEvent(exerciseEventId, exerciseTypeId);
    }

}
