package com.sprint.otms.exceptions;

public class AdminNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -449418051625912141L;

	/**
	 * 
	 */
	public AdminNotFoundException() {
		super();
	}

	/**
	 * @param message
	 */
	public AdminNotFoundException(String message) {
		super(message);
	}
}
