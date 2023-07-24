package com.example.fitnesstrackerbackend.service;

import com.example.fitnesstrackerbackend.models.enums.Bodypart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.fitnesstrackerbackend.repository.ExerciseRepository;
import com.example.fitnesstrackerbackend.models.Exercise;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExerciseService {

  private final ExerciseRepository exerciseRepository;

  public Exercise save(Exercise exercise) {
    return exerciseRepository.save(exercise);
  }

  public Optional<Exercise> findById(long id) {
    return exerciseRepository.findById(id);
  }

  public List<Exercise> searchByName(String name) {
    return exerciseRepository.searchByName(name);
  }

  public List<Exercise> findByBodypart(Bodypart bodypart) {
    return exerciseRepository.findByBodypart(bodypart);
  }

  public void deleteById(long id) {
    exerciseRepository.deleteById(id);
  }

  public void delete(Exercise exercise) {
    exerciseRepository.delete(exercise);
  }

  public List<Exercise> findAll() {
    return exerciseRepository.findAll();
  }
}
