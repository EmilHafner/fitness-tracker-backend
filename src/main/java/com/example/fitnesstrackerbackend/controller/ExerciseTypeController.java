package com.example.fitnesstrackerbackend.controller;

import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import com.example.fitnesstrackerbackend.models.ExerciseType;
import com.example.fitnesstrackerbackend.models.enums.Bodypart;
import com.example.fitnesstrackerbackend.service.ExerciseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exercises")
public class ExerciseTypeController {

  private final ExerciseTypeService exerciseTypeService;

  @GetMapping("/all")
  public List<ExerciseType> getAllExercises() {
    return exerciseTypeService.findAll();
  }

  @GetMapping("/{bodypart}")
  public List<ExerciseType> getExercisesByBodypart(@PathVariable Bodypart bodypart) {
    return exerciseTypeService.findByBodypart(bodypart);
  }

  @PostMapping("/add")
  public ExerciseType addExercise(@RequestBody ExerciseType exerciseType) throws ValidationException, ConflictException {
    return exerciseTypeService.save(exerciseType);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteExercise(@PathVariable Long id) {
    exerciseTypeService.deleteById(id);
  }

  @GetMapping("/search/{name}")
  public List<ExerciseType> searchByName(@PathVariable String name) {
    return exerciseTypeService.searchByName(name);
  }

  @PatchMapping("/update/{id}")
  public ExerciseType updateExercise(@RequestParam Long id, @RequestBody ExerciseType exerciseType) {
    exerciseType.setId(id);
    return exerciseTypeService.updateExercise(exerciseType);
  }

  @GetMapping("/bodyparts")
  public Bodypart[] getBodyparts() {
    return Bodypart.values();
  }

}
