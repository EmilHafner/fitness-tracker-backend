package com.example.fitnesstrackerbackend.models;

import com.example.fitnesstrackerbackend.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString @RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "exercise_plans")
public class ExercisePlan {
  @Id
  @GeneratedValue
  private Long id;

  @JsonIgnore
  @ManyToOne
  private User user;

  private String name;

  private String description;

  @OneToMany @ToString.Exclude
  private List<ExerciseType> exerciseTypes;

}
