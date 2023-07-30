package com.example.fitnesstrackerbackend.repository;

import com.example.fitnesstrackerbackend.models.TrainingsSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingsSetRepository extends JpaRepository<TrainingsSet, Long> {


}
