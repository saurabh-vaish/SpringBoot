package com.app.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 625652365974134400L;

	public EmployeeNotFoundException(String s) {
		super(s);
	}
	
}
