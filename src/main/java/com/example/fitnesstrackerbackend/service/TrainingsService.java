package com.example.fitnesstrackerbackend.service;


import com.example.fitnesstrackerbackend.controller.dto.TrainingDto;
import com.example.fitnesstrackerbackend.models.Training;
import com.example.fitnesstrackerbackend.repository.TrainingsRepository;
import com.example.fitnesstrackerbackend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingsService {

    private final TrainingsRepository trainingsRepository;

    /**
     * Get all trainings for a user.
     *
     * @param user the user
     * @return A list of all trainings for the user.
     */
    public List<Training> getAllTrainingsForUser(User user) {
        return trainingsRepository.findTrainingsByUser(user);
    }

    /**
     * Save a training for a user.
     * @param training the training
     * @param user the user
     * @return the saved training
     */
    public Training saveTraining(TrainingDto training, User user) {
        return trainingsRepository.save(
                Training.builder()
                        .startDateTime(Date.valueOf(training.startDateTime()))
                        .duration(Time.valueOf(training.duration()))
                        .user(user)
                        .build()
        );
    }


}
