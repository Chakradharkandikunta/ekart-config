package com.infosys.ekart.account.exception;

/**
 * 
 * This Exception is thrown from AccountService class with error message if 
 * the email id is already used for account SignUp
 *   
 * 
 *
 */
public class EmailIdAlreadyExistsException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public EmailIdAlreadyExistsException(String message) {
		super(message);
	}
}
