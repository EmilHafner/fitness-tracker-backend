package com.example.fitnesstrackerbackend.repository;

import com.example.fitnesstrackerbackend.models.Exercise;
import com.example.fitnesstrackerbackend.models.enums.Bodypart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

  List<Exercise> findByBodypart(Bodypart bodypart);

  List<Exercise> searchByName(String name);

}
