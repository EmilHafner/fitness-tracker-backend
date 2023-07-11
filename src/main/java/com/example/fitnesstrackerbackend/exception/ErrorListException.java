package com.example.fitnesstrackerbackend.exception;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * This exception is thrown when a list of errors is encountered. The list of errors is passed to the
 * front end.
 */
public class ErrorListException extends Exception {

  private final List<String> errors;
  private final String messageSummary;
  private final String errorListDescriptor;

  /**
   * Constructor for ErrorListException.
   *
   * @param errorListDescription a short description of the list of errors
   * @param messageSummary       a short summary of the error
   * @param errors               the list of errors
   */
  public ErrorListException(String errorListDescription, String messageSummary, List<String> errors) {
    super(messageSummary);
    this.errors = errors;
    this.messageSummary = messageSummary;
    this.errorListDescriptor = errorListDescription;
  }

  /**
   * See {@link Throwable#getMessage()} for general information about this method.
   *
   * <p>Note: this implementation produces the message
   * from the {@link #summary} and the list of {@link #errors}
   */
  @Override
  public String getMessage() {
    return "%s. %s: %s."
            .formatted(messageSummary, errorListDescriptor, String.join(", ", errors));
  }

  /**
   * @return a short description of the list of errors
   */
  public String summary() {
    return messageSummary;
  }

  /**
   * @return the list of errors
   */
  public List<String> errors() {
    return Collections.unmodifiableList(errors);
  }


}
