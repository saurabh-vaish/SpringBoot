package com.app.exception;

public class CustomerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5905993208620365382L;
	
	public CustomerNotFoundException(String string) {
			
		super(string);
	}


}
