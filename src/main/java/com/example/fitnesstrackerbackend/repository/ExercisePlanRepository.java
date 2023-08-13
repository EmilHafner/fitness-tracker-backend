package com.example.fitnesstrackerbackend.repository;

import com.example.fitnesstrackerbackend.models.ExercisePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercisePlanRepository extends JpaRepository<ExercisePlan, Long> {

  List<ExercisePlan> findAllByUserId(long userId);

}
