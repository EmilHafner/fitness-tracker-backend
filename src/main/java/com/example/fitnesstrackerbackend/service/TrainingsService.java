package com.example.fitnesstrackerbackend.service;


import com.example.fitnesstrackerbackend.repository.TrainingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingsService {

    private final TrainingsRepository trainingsRepository;

    

}
