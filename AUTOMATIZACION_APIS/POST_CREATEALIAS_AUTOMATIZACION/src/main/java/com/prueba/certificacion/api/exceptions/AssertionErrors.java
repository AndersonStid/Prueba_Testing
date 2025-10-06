package com.prueba.certificacion.api.exceptions;

public class AssertionErrors extends AssertionError {

    public AssertionErrors(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionErrors(String message) {
    }
}