package com.infosys.ekart.address.exception;

/**
 * 
 * This Exception is thrown from AddressService class with error message if 
 * the address id for the given user Id doesn't exist in the database
 * 
 *
 */
public class AddressIdForUserDoesNotExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public AddressIdForUserDoesNotExistsException(String message) {
		super(message);
	}
}
