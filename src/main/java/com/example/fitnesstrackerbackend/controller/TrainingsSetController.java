package com.example.fitnesstrackerbackend.controller;

import com.example.fitnesstrackerbackend.exception.NotFoundException;
import com.example.fitnesstrackerbackend.models.TrainingsSet;
import com.example.fitnesstrackerbackend.service.TrainingsSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trainingsSets")
public class TrainingsSetController {

  private final TrainingsSetService trainingsSetService;

  @GetMapping("/{trainingsSetId}")
  public TrainingsSet getTrainingsSetById(@PathVariable Long trainingsSetId) throws NotFoundException {
    return trainingsSetService.getTrainingsSetById(trainingsSetId);
  }

  @PutMapping("/{trainingsSetId}")
  public TrainingsSet updateTrainingsSet(@PathVariable Long trainingsSetId,
                                         @RequestBody TrainingsSet trainingsSet) throws NotFoundException {
    trainingsSet.setId(trainingsSetId);
    return trainingsSetService.update(trainingsSet);
  }

  @DeleteMapping("/{trainingsSetId}")
  public Long deleteTrainingsSetById(@PathVariable Long trainingsSetId) throws NotFoundException {
    return trainingsSetService.deleteById(trainingsSetId);
  }

}
