package com.sprint.otms.exceptions;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {
		super();
	}
	
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
