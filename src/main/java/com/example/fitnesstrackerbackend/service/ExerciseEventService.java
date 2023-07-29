package com.example.fitnesstrackerbackend.service;

import com.example.fitnesstrackerbackend.models.ExerciseEvent;
import com.example.fitnesstrackerbackend.repository.ExerciseEventRepository;
import com.example.fitnesstrackerbackend.service.validators.AccessValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseEventService {


  private final ExerciseEventRepository exerciseEventRepository;

  public ExerciseEvent getExerciseEventById(long id) {
    return exerciseEventRepository.findById(id).orElse(null);
  }

  public ExerciseEvent save(ExerciseEvent exerciseEvent) {
    return exerciseEventRepository.save(exerciseEvent);
  }

}
