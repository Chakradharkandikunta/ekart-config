package com.infosys.ekart.address.exception;

/**
 * 
 * This Exception is thrown from AddressService class with error message if 
 * the city provided during address addition or address modification
 * contains any special characters other than space 
 *
 */
public class InvalidCityException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidCityException(String message) {
		super(message);
	}
}
