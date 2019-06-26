package com.infosys.ekart.address.exception;

/**
 * 
 * This Exception is thrown from AddressService class with error message if 
 * the address id doesn't exist in the database
 * 
 *
 */
public class AddressIdDoesNotExistsException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public AddressIdDoesNotExistsException(String message) {
		super(message);
	}

}
