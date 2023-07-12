package com.example.fitnesstrackerbackend.repository;

import com.example.fitnesstrackerbackend.models.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingsRepository extends JpaRepository<Training, Integer> {

  /**
   * Find a training by id
   * @param integer the id to search for
   * @return Optional containing the training if found, empty otherwise
   */
  @Override Optional<Training> findById(Integer integer);
}
