package com.example.fitnesstrackerbackend.models;

import com.example.fitnesstrackerbackend.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter @Setter @RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "trainings")
public class Training {
  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne
  @JoinColumn(nullable = false, name = "user_id", foreignKey = @ForeignKey(name = "fk_trainings_users"))
  @JsonIgnore
  private User user;
  @Column(nullable = false, name = "start_date_time")
  private Date startDateTime;
  @Column(nullable = true, name = "end_date_time")
  private Date endDateTime;

  @OneToMany(mappedBy = "training")
  private List<ExerciseEvent> exerciseEvents;

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
    Training training = (Training) o;
    return getId()
            != null
            && Objects.equals(getId(), training.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ?
            ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
            getClass().hashCode();
  }
}
