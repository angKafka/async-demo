package org.rdutta.localaccounts.handler;

import org.rdutta.localaccounts.exceptions.UserExceptions;
import org.rdutta.localaccounts.utilities.features.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsersExceptionHandler {

    @ExceptionHandler(UserExceptions.class)
    public ResponseEntity<ErrorDetails> handleUserException(UserExceptions userExceptions) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .errorStatus(HttpStatus.BAD_REQUEST.value())
                .errorMessage(userExceptions.getMessage())
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
