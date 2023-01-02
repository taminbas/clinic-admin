package com.clinicadminservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NoDataFoundException extends RuntimeException {

    private static final long serialVersionUID = 5344320715962995240L;
    private String message;

    public NoDataFoundException() {}

    public NoDataFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
