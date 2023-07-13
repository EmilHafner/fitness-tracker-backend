package com.example.fitnesstrackerbackend.controller;

import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.NotFoundException;
import com.example.fitnesstrackerbackend.models.Training;
import com.example.fitnesstrackerbackend.service.TrainingsService;
import com.example.fitnesstrackerbackend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/training")
public class TrainingController {

    private final TrainingsService trainingsService;

    @GetMapping("/all-trainings")
    public List<Training> getAllTrainingsForCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return trainingsService.getAllTrainingsForUser(user);
    }

    @PostMapping("/add-training")
    public Training addTraining(@RequestBody Training training) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        training.setUser(user);

        // TODO: Validate training

        return trainingsService.saveTraining(training);
    }

    @PatchMapping("/stop-training/{trainingId}")
    public Training stopTraining(@PathVariable Long trainingId) throws ConflictException, NotFoundException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return trainingsService.stopTrainingWithIdAndUser(trainingId, user);
    }


}
