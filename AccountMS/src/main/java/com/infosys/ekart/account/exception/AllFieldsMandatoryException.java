package com.infosys.ekart.account.exception;

/**
 * 
 * This Exception is thrown from AccountService class with error message if all
 * the fields are not provided during SignUp
 * 
 * 
 *
 */
public class AllFieldsMandatoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public AllFieldsMandatoryException(String message) {
		super(message);
	}

}
