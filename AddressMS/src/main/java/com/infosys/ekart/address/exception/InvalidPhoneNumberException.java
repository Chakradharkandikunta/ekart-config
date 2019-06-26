package com.infosys.ekart.address.exception;

/**
 * 
 * This Exception is thrown from AddressService class with error message if 
 * the phone number provided during address addition or address modification
 * is not of length 10
 *
 */
public class InvalidPhoneNumberException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidPhoneNumberException(String message) {
		super(message);
	}
}
