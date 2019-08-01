package com.app.exception;

public class StudentNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = -6298373885941900704L;

	
	public StudentNotFoundException(String s) 
	{
		super(s);
	}
	
}
