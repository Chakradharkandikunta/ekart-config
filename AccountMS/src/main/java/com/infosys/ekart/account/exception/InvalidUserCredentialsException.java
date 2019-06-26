package com.infosys.ekart.account.exception;


/**
 * 
 * This Exception is thrown from AccountService class with error message if 
 * the user Id and the password provided during account Login 
 * doesn't match the login data in the user database
 *
 */
public class InvalidUserCredentialsException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidUserCredentialsException(String message) {
		super(message);
	}
}
