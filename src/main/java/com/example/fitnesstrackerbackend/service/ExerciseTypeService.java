package com.example.fitnesstrackerbackend.service;

import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import com.example.fitnesstrackerbackend.models.ExerciseType;
import com.example.fitnesstrackerbackend.models.enums.Bodypart;
import com.example.fitnesstrackerbackend.service.validators.ExerciseTypeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.fitnesstrackerbackend.repository.ExerciseTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExerciseTypeService {

  private final ExerciseTypeRepository exerciseTypeRepository;
  private final ExerciseTypeValidator exerciseTypeValidator;

  public ExerciseType save(ExerciseType exerciseType) throws ValidationException, ConflictException {
    exerciseTypeValidator.validateForSaveOrUpdate(exerciseType);
    return exerciseTypeRepository.save(exerciseType);
  }

  public Optional<ExerciseType> findById(long id) {
    return exerciseTypeRepository.findById(id);
  }

  public List<ExerciseType> searchByName(String name) {
    return exerciseTypeRepository.searchByName(name);
  }

  public List<ExerciseType> findByBodypart(Bodypart bodypart) {
    return exerciseTypeRepository.findByBodypart(bodypart);
  }

  public void deleteById(long id) {
    exerciseTypeRepository.deleteById(id);
  }

  public void delete(ExerciseType exerciseType) {
    exerciseTypeRepository.delete(exerciseType);
  }

  public List<ExerciseType> findAll() {
    return exerciseTypeRepository.findAll();
  }

  public ExerciseType updateExercise(ExerciseType exerciseType) {
    //TODO make sure that the exerciseType exists in the database. If not, throw an exception
    //Maybe it is enough to just check if the id is not null?
    return exerciseTypeRepository.save(exerciseType);
  }
}
