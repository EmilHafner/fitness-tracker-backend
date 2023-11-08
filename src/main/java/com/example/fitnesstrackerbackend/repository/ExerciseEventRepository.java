package com.example.fitnesstrackerbackend.repository;

import com.example.fitnesstrackerbackend.models.ExerciseEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseEventRepository extends JpaRepository<ExerciseEvent, Long> {

}
