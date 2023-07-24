package com.example.fitnesstrackerbackend.repository;

import com.example.fitnesstrackerbackend.models.ExerciseInTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseInTrainingRepository extends JpaRepository<ExerciseInTraining, Long> {


}
