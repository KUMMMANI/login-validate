package com.me.exceptions;

@SuppressWarnings("serial")
public class PhoneNumberAlreadyExistingException extends RuntimeException {
	
	public PhoneNumberAlreadyExistingException(String message) {
		super(message);
	}

}
