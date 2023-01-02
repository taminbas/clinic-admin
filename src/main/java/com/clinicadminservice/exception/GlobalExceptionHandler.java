package com.clinicadminservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoDataFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoDataFoundException (NoDataFoundException ex) {
        ErrorResponse eObject = new ErrorResponse();
        eObject.setStatus(HttpStatus.NO_CONTENT.value());
        eObject.setMessage(ex.getMessage());
        eObject.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorResponse>(eObject, HttpStatus.OK);
    }

}
