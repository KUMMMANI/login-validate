package com.me.exceptions;

@SuppressWarnings("serial")
public class UserNameAlreadyExistingException extends RuntimeException {

	public UserNameAlreadyExistingException(String message) {
		super(message);
	}

}