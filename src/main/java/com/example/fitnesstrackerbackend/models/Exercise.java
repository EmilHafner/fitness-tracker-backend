package com.example.fitnesstrackerbackend.models;

import com.example.fitnesstrackerbackend.models.enums.Bodypart;
import jakarta.persistence.Entity;
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
    private Integer id;
    private String name;
    private Bodypart bodypart;
}
