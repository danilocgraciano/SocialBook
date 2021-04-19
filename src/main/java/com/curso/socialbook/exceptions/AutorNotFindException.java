package com.curso.socialbook.exceptions;

public class AutorNotFindException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AutorNotFindException(String message) {
		super(message);
	}
	
	public AutorNotFindException(String message, Throwable cause) {
		super(message, cause);
	}
}
