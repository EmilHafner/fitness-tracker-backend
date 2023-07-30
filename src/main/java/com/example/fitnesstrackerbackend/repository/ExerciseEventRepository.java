package com.example.fitnesstrackerbackend.repository;

import com.example.fitnesstrackerbackend.models.ExerciseEvent;
import com.example.fitnesstrackerbackend.models.TrainingsSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseEventRepository extends JpaRepository<ExerciseEvent, Long> {

}
