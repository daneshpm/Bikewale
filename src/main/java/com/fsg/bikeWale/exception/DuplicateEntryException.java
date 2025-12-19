package com.fsg.bikeWale.exception;

public class DuplicateEntryException extends RuntimeException {

	private String message;

	public DuplicateEntryException() {
		super("Duplicate entry found");
		this.message = "Duplicate entry found";
	}

	public DuplicateEntryException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}