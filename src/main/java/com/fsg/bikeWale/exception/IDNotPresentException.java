package com.fsg.bikeWale.exception;

public class IDNotPresentException extends RuntimeException {

	private String message = "Give ID does not exists";

	public IDNotPresentException() {

	}

	public IDNotPresentException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
