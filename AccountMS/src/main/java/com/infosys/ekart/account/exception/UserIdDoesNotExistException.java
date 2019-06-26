package com.infosys.ekart.account.exception;

/**
 * 
 * This Exception is thrown from AccountService class with error message if the
 * user id doesn't exist in the database
 * 
 * 
 *
 */
public class UserIdDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserIdDoesNotExistException(String message) {
		super(message);
	}
}
