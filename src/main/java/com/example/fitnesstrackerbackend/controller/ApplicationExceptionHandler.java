package com.example.fitnesstrackerbackend.controller;

import com.example.fitnesstrackerbackend.controller.dto.ConflictExceptionDto;
import com.example.fitnesstrackerbackend.controller.dto.ValidationExceptionDto;
import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class ApplicationExceptionHandler {

  Logger logger = Logger.getLogger(ApplicationExceptionHandler.class.getName());

  @ExceptionHandler
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public ValidationExceptionDto handleValidationException(ValidationException e) {
    logger.log(Level.WARNING,
            String.format("Terminating request processing with status 422 due to %s: %s", e.getClass().getSimpleName(),
                    e.getMessage()));
    return new ValidationExceptionDto(e.summary(), e.errors());
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.CONFLICT)
  @ResponseBody
  public ConflictExceptionDto handleConflictException(ConflictException e) {
    logger.log(Level.WARNING,
            String.format("Terminating request processing with status 409 due to %s: %s", e.getClass().getSimpleName(),
                    e.getMessage()));
    return new ConflictExceptionDto(e.summary(), e.errors());
  }
}
