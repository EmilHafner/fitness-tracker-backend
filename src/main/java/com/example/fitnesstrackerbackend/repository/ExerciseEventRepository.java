package com.example.fitnesstrackerbackend.repository;

import com.example.fitnesstrackerbackend.models.ExerciseEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseEventRepository extends JpaRepository<ExerciseEvent, Long> {

}
