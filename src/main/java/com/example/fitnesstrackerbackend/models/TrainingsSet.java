package com.example.fitnesstrackerbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Getter @Setter @ToString @RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class TrainingsSet {
  @Id
  @GeneratedValue
  private Long id;

  private Integer reps;
  private Float weight;

  private Integer orderNumber;

  @ManyToOne(optional = false)
  @JsonIgnore
  private ExerciseEvent exerciseEvent;

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
    TrainingsSet that = (TrainingsSet) o;
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
