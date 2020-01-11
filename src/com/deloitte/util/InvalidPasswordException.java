package com.deloitte.util;

public class InvalidPasswordException extends Exception {
	private static final long serialVersionUID = 4781074757671511971L;

	public InvalidPasswordException() {
		super("Password should be greater than 8 characters");
	}
}
