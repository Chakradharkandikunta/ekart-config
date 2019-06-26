package com.infosys.ekart.address.exception;

/**
 * 
 * This Exception is thrown from AddressService class with error message if the
 * state provided during address addition or address modification doesn't match
 * any of the 29 states in India
 *
 */
public class InvalidStateException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidStateException(String message) {
		super(message);
	}
}
