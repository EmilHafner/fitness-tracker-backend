package com.example.fitnesstrackerbackend.service;


import com.example.fitnesstrackerbackend.controller.dto.TrainingDto;
import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.NotFoundException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import com.example.fitnesstrackerbackend.models.Training;
import com.example.fitnesstrackerbackend.repository.TrainingsRepository;
import com.example.fitnesstrackerbackend.service.validators.TrainingValidator;
import com.example.fitnesstrackerbackend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainingsService {

    private final TrainingsRepository trainingsRepository;
    private final TrainingValidator trainingValidator;

    /**
     * Get all trainings for a user.
     *
     * @param user the user
     * @return A list of all trainings for the user.
     */
    public List<TrainingDto> getAllTrainingsForUser(User user) {
        return trainingsRepository.findTrainingsByUser(user).stream().map(this::convertToDto).toList();
    }

    /**
     * Save a training.
     *
     * @param training the training to save
     * @return the saved training
     */
    public Training saveTraining(Training training) throws ValidationException, ConflictException {
        trainingValidator.validateForSaveTraining(training);

        return trainingsRepository.save(training);
    }

    public Training stopTrainingWithIdAndUser(Long id, User user) throws NotFoundException, ConflictException {
        Training training = trainingsRepository.getTrainingById(id).orElseThrow(
                () -> new NotFoundException(String.format("Training with Id %s not found", id)));

        if (!training.getUser().getId().equals(user.getId())) {
            throw new NotFoundException(String.format("Training with id %s not found for user with id %s", id, user.getId()));
        }

        //Make sure the updated data is correct
        trainingValidator.validateForStopTraining(training);

        training.setEndDateTime(new Date(System.currentTimeMillis()));
        return trainingsRepository.save(training);
    }

    private TrainingDto convertToDto(Training training) {
        return new TrainingDto(
                training.getId(),
                training.getUser().getId(),
                training.getStartDateTime(),
                training.getEndDateTime()
        );
    }


  public void deleteTrainingWithIdAndUser(Long trainingId, User user) throws NotFoundException {
    Training training = trainingsRepository.getTrainingById(trainingId).orElseThrow(
            () -> new NotFoundException(String.format("Training with Id %s not found", trainingId)));

    if (!training.getUser().getId().equals(user.getId())) {
      throw new NotFoundException(String.format("Training with id %s not found for user with id %s", trainingId, user.getId()));
    }

    trainingsRepository.delete(training);
  }

    public Optional<Training> getTrainingByIdAndUser(Long trainingId, User user) {

        return trainingsRepository.getTrainingByIdAndUser(trainingId, user);

    }
}
