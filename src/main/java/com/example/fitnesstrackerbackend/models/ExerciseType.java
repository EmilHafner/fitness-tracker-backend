package com.example.fitnesstrackerbackend.models;

import com.example.fitnesstrackerbackend.models.enums.Bodypart;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

// Entity class for gym exercises
@Getter @Setter @ToString @RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name="exercise_types")
public class ExerciseType {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Bodypart bodypart;

  @Override
  public final boolean equals(Object o) {
    if (this
            == o) return true;
    if (o
            == null) return false;
    Class<?> oEffectiveClass = o instanceof HibernateProxy ?
            ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() :
            o.getClass();
    Class<?> thisEffectiveClass = this instanceof HibernateProxy ?
            ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() :
            this.getClass();
    if (thisEffectiveClass
            != oEffectiveClass) return false;
    ExerciseType that = (ExerciseType) o;
    return getId()
            != null
            && Objects.equals(getId(), that.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ?
            ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
            getClass().hashCode();
  }
}
