package com.deloitte.util;

public class UserDoesNotExistException extends Exception {
	private static final long serialVersionUID = 376507403189055159L;
	
	public UserDoesNotExistException() {
		super("User doesn't exist");
	}
}
