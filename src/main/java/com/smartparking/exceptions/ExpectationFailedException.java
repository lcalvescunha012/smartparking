package com.smartparking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExpectationFailedException extends ResponseStatusException {
    public ExpectationFailedException(String message) {
        super(HttpStatus.EXPECTATION_FAILED, message);
    }
}
