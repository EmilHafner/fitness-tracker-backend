package com.example.fitnesstrackerbackend.service;

import com.example.fitnesstrackerbackend.exception.NotFoundException;
import com.example.fitnesstrackerbackend.models.TrainingsSet;
import com.example.fitnesstrackerbackend.repository.TrainingsSetRepository;
import com.example.fitnesstrackerbackend.service.validators.AccessValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingsSetService {

  private final TrainingsSetRepository trainingsSetRepository;
  private final AccessValidator accessValidator;

  public TrainingsSet getTrainingsSetById(Long id) throws NotFoundException {

    TrainingsSet trainingsSet = trainingsSetRepository.findById(id).orElseThrow(() ->
            new NotFoundException(String.format("TrainingsSet with Id %s not found", id)));
    accessValidator.validateAccessToTrainingsSet(trainingsSet);

    return trainingsSet;
  }

  public TrainingsSet update(TrainingsSet trainingsSet) throws NotFoundException {


    TrainingsSet old = trainingsSetRepository.findById(trainingsSet.getId()).orElseThrow(() ->
            new NotFoundException(String.format("TrainingsSet with Id %s not found", trainingsSet.getId())));

    accessValidator.validateAccessToTrainingsSet(old);

    // Update only the fields that are allowed to be updated
    if (trainingsSet.getReps() != null) old.setReps(trainingsSet.getReps());
    if (trainingsSet.getWeight() != null) old.setWeight(trainingsSet.getWeight());
    if (trainingsSet.getOrderNumber() != null) old.setOrderNumber(trainingsSet.getOrderNumber());

    return trainingsSetRepository.save(old);
  }

  public Long deleteById(Long id) throws NotFoundException {
    accessValidator.validateAccessToTrainingsSet(id);
    trainingsSetRepository.deleteById(id);
    return id;
  }

}
