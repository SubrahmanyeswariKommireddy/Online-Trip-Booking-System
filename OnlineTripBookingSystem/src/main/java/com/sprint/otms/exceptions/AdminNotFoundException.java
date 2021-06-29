package com.sprint.otms.exceptions;

/**
 * 
 * @author Susmitha
 *
 */
public class AdminNotFoundException extends RuntimeException {


	/**
	 * Default Constructor
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
