package com.smartparking.exceptions;

public class ZonaNotFoundException extends RuntimeException {
    public ZonaNotFoundException(String message) {
        super(message);
    }
}