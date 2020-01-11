package com.deloitte.util;

public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = -4481066473355353202L;
	
	public UserAlreadyExistsException() {
		super("User already exist with the same User ID");
	}
}
