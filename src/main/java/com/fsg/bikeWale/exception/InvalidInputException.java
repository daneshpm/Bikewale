package com.fsg.bikeWale.exception;

public class InvalidInputException extends RuntimeException {

    private String message;

    // Zero-argument constructor
    public InvalidInputException() {
        super("Invalid input provided");
        this.message = "Invalid input provided";
    }

    // Parameterized constructor
    public InvalidInputException(String message) {
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
