package com.fsg.bikeWale.exception;

public class ValidationException extends RuntimeException {

    private String message;

    // Zero-argument constructor
    public ValidationException() {
        super("Validation failed");
        this.message = "Validation failed";
    }

    // Parameterized constructor
    public ValidationException(String message) {
        super(message);
        this.message = message;
    }

    // Getter
    public String getMessage() {
        return message;
    }

    // Setter
    public void setMessage(String message) {
        this.message = message;
    }
}