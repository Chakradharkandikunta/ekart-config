package com.infosys.ekart.account.exception;

/**
 * 
 * This Exception is thrown from AccountService class with error message if 
 * the password and the custom password provided during account SignUp 
 * doesn't match
 *
 */
public class ConfirmPasswordMismatchException extends Exception{
	private static final long serialVersionUID = 1L;

	public ConfirmPasswordMismatchException(String message) {
		super(message);
	}
}
