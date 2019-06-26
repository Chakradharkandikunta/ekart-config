package com.infosys.ekart.account.exception;

/**
 * 
 * This Exception is thrown from AccountService class with error message if 
 * an invalid character is present in the name provided during account SignUp
 *   
 * 
 *
 */
public class InvalidCharacterInNameException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidCharacterInNameException(String message) {
		super(message);
	}
}
