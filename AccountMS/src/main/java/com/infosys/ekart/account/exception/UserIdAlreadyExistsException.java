package com.infosys.ekart.account.exception;

/**
 * 
 * This Exception is thrown from AccountService class with error message if 
 * the user id is already used for account SignUp
 *   
 * 
 *
 */
public class UserIdAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserIdAlreadyExistsException(String message) {
		super(message);
	}
}
