package com.example.bookstore.mgmt.exception;

public class ValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String massage;

	public ValidationException(String massage) {
		this.massage = massage;
	}
	
	public String getMessage() {
		return this.massage;
	}
	
}
