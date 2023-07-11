package com.example.fitnesstrackerbackend.exception;

import java.util.List;


/**
 * Exception that signals, that a request could not be processed due to a conflict with the current state of the system.
 */
public class ConflictException extends ErrorListException {
  /**
   * @param messageSummary a summary of the error messages
   * @param errors the list of errors that failed when checking the piece of data in question for conflicts
   */
  public ConflictException(String messageSummary, List<String> errors) {
    super("Conflict", messageSummary, errors);
  }
}
