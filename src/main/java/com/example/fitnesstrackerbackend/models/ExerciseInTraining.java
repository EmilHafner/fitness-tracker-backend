package com.example.fitnesstrackerbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exercise_training")
public class ExerciseInTraining {
  @Id
  @GeneratedValue
  private Long id;
  @OneToOne
  private Training training;
  @OneToOne
  private Exercise exercise;
  @OneToMany
  private List<TrainingsSet> set;
  private Integer orderNumber;
}
