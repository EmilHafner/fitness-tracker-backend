package com.example.fitnesstrackerbackend.models;

import com.example.fitnesstrackerbackend.models.enums.Bodypart;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

// Entity class for gym exercises
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="exercises")
public class Exercise {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Bodypart bodypart;
}
