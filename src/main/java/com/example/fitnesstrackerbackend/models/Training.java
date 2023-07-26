package com.example.fitnesstrackerbackend.models;

import com.example.fitnesstrackerbackend.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trainings")
public class Training {
  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne
  @JoinColumn(nullable = false)
  private User user;
  private Date startDateTime;
  private Date endDateTime;
  @ManyToOne @JoinColumn(name = "exercise_in_training_id")
  private ExerciseInTraining exerciseInTraining;
}
