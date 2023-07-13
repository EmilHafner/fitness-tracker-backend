package com.example.fitnesstrackerbackend.controller;

import com.example.fitnesstrackerbackend.controller.dto.TrainingDto;
import com.example.fitnesstrackerbackend.models.Training;
import com.example.fitnesstrackerbackend.service.TrainingsService;
import com.example.fitnesstrackerbackend.service.UserService;
import com.example.fitnesstrackerbackend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trainings")
public class TrainingsController {

    private final TrainingsService trainingsService;

    @PostMapping("/add-training")
    public Training addTraining(@RequestBody TrainingDto training) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // TODO: Add Validation for TrainingDto.

        return trainingsService.saveTraining(training, user);
    }

}
