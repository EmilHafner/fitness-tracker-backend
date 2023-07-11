package com.example.fitnesstrackerbackend.exception;

import java.util.List;

/**
 * Exception that signals, that a request has invalid data.
 */
public class ValidationException extends ErrorListException {
  /**
   *
   * @param messageSummary a summary of the error messages
   * @param errors the list of errors that failed when validating the piece of data in question
   */
  public ValidationException(String messageSummary, List<String> errors) {
    super("Failed validations", messageSummary, errors);
  }

}
