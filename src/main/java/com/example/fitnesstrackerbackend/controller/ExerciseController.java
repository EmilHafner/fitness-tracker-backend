package com.example.fitnesstrackerbackend.controller;

import com.example.fitnesstrackerbackend.models.Exercise;
import com.example.fitnesstrackerbackend.models.enums.Bodypart;
import com.example.fitnesstrackerbackend.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exercises")
public class ExerciseController {

  private final ExerciseService exerciseService;

  @GetMapping("/all")
  public List<Exercise> getAllExercises() {
    return exerciseService.findAll();
  }

  @GetMapping("/{bodypart}")
  public List<Exercise> getExercisesByBodypart(@PathVariable Bodypart bodypart) {
    return exerciseService.findByBodypart(bodypart);
  }

  @PostMapping("/add")
  public Exercise addExercise(Exercise exercise) {
    return exerciseService.save(exercise);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteExercise(@PathVariable Long id) {
    exerciseService.deleteById(id);
  }

  @GetMapping("/search/{name}")
  public List<Exercise> searchByName(@PathVariable String name) {
    return exerciseService.searchByName(name);
  }

  @PatchMapping("/update")
  public Exercise updateExercise(Exercise exercise) {
    return exerciseService.updateExercise(exercise);
  }

}
