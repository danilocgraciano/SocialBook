package com.curso.socialbooks.exceptions;

public class LivroException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LivroException(String message) {
		super(message);
	}
	
	public LivroException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
