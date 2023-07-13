package com.example.fitnesstrackerbackend.repository;

import com.example.fitnesstrackerbackend.models.Training;
import com.example.fitnesstrackerbackend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingsRepository extends JpaRepository<Training, Long> {
  List<Training> findTrainingsByUser(User user);

    Optional<Training> getTrainingById(Long id);

}
