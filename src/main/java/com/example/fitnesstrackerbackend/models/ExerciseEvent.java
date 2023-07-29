package com.example.fitnesstrackerbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Getter @Setter @ToString @RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "exercise_events")
public class ExerciseEvent {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  private ExerciseType exerciseType;

  @ManyToOne(optional = false)
  @JsonIgnore
  private Training training;

  @OneToMany @ToString.Exclude
  private List<TrainingsSet> trainingsSets;

  private Integer orderNumber;

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
    ExerciseEvent that = (ExerciseEvent) o;
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
