package com.fsg.bikeWale.exception;

public class RelationNotFoundException extends RuntimeException {

    private String message;

    // Zero-argument constructor
    public RelationNotFoundException() {
        super("Related entity not found");
        this.message = "Related entity not found";
    }

    // Parameterized constructor
    public RelationNotFoundException(String message) {
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
