package com.example.fitnesstrackerbackend.models;

import com.example.fitnesstrackerbackend.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
  private Integer id;
  @ManyToOne
  private User user;
  private Date startDateTime;
  private Time duration;
}
