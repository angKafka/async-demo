package org.rdutta.crm.global;

import org.rdutta.crm.custom_exceptions.EmployeeNotFound;
import org.rdutta.crm.error.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.security.core.AuthenticationException;

@ControllerAdvice
public class GlobalException{

    @ExceptionHandler
   public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFound employeeNotFound) {
       EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
       errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
       errorResponse.setMessage(employeeNotFound.getMessage());
       errorResponse.setTimestamp(System.currentTimeMillis());
       return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
   }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(AuthenticationException ex) {
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
