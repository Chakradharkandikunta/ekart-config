package com.infosys.ekart.address.exception;

/**
 * 
 * This Exception is thrown from AddressService class with error message if 
 * the pin code provided during address addition or address modification
 * is not of length 6
 *
 */
public class InvalidPincodeException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidPincodeException(String message) {
		super(message);
	}
}
