package com.infosys.ekart.account.exception;

/**
 * 
 * This Exception is thrown from AccountService class with error message if 
 * the password provided during account SignUp 
 * doesn't meet the required conditions
 *
 */
public class InvalidPasswordException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(String message) {
		super(message);
	}
}
