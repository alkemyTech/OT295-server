package com.alkemy.ong.exception;

import com.alkemy.ong.domain.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleException {


  @ExceptionHandler(value = InsufficientPermissionsException.class)
  public ResponseEntity<ErrorResponse> handlerInsufficientPermissionsException(
      InsufficientPermissionsException e) {
    ErrorResponse error = buildErrorResponse(HttpStatus.FORBIDDEN, e.getMessage());
    return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
  }

  private ErrorResponse buildErrorResponse(HttpStatus httpStatus, String message) {
    ErrorResponse error = new ErrorResponse();
    error.setStatus(httpStatus.value());
    error.add(message);
    error.setTimestamp(TimestampUtils.now());
    return error;
  }

}
