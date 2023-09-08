package com.example.fitnesstrackerbackend.controller;

import com.example.fitnesstrackerbackend.controller.dto.ConflictExceptionDto;
import com.example.fitnesstrackerbackend.controller.dto.NotFoundExceptionDto;
import com.example.fitnesstrackerbackend.controller.dto.ValidationExceptionDto;
import com.example.fitnesstrackerbackend.exception.ConflictException;
import com.example.fitnesstrackerbackend.exception.NotFoundException;
import com.example.fitnesstrackerbackend.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class ApplicationExceptionHandler {


    private final Logger logger = Logger.getLogger(ApplicationExceptionHandler.class.getName());

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

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public NotFoundExceptionDto handleNotFoundException(NotFoundException e) {
        logger.log(Level.WARNING,
                String.format("Terminating request processing with status 404 due to %s: %s", e.getClass().getSimpleName(),
                        e.getMessage()));
        return new NotFoundExceptionDto(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public NotFoundExceptionDto handleBadCredentialsException(BadCredentialsException e) {
        logger.log(Level.WARNING,
                String.format("Terminating request processing with status 404 due to %s: %s", e.getClass().getSimpleName(),
                        e.getMessage()));
        return new NotFoundExceptionDto(e.getMessage());
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Exception e) {
        logger.log(Level.SEVERE,
                String.format("Terminating request processing with status 500 due to %s: %s", e.getClass().getSimpleName(),
                        e.getMessage()));
        return String.format("Internal Server Error: %s", e.getMessage());
    }

}
