package com.app.exception;

public class ItemNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -684960463839293165L;

	public ItemNotFoundException(String string) {
		super(string);
	}

}
