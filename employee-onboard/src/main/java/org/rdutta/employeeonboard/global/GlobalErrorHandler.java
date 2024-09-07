package org.rdutta.employeeonboard.global;

import org.rdutta.employeeonboard.exceptions.UserExceptions;
import org.rdutta.employeeonboard.utilities.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler({UserExceptions.class})
    public ResponseEntity<ErrorDetails> handle(UserExceptions ex) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .errorCode(HttpStatus.BAD_REQUEST.value())
                .errorMessage(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
