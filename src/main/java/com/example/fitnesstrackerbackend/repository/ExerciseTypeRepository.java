package com.example.fitnesstrackerbackend.repository;

import com.example.fitnesstrackerbackend.models.ExerciseType;
import com.example.fitnesstrackerbackend.models.enums.Bodypart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Long> {

  Optional<ExerciseType> findById(long id);

  List<ExerciseType> findByBodypart(Bodypart bodypart);

  List<ExerciseType> searchByName(String name);

}
