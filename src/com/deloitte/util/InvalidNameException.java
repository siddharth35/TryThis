package com.deloitte.util;

public class InvalidNameException extends Exception {
	private static final long serialVersionUID = -8518910098698253154L;

	public InvalidNameException() {
		super("Name should be greater than 2 Characters");
	}
}
