package com.deloitte.util;

public class InvalidIDException extends Exception {
	private static final long serialVersionUID = 4243231735112962315L;

	public InvalidIDException() {
		super("ID should be of 5 characters");
	}
}
