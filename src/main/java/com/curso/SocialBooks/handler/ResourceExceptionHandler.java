package com.curso.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.curso.socialbooks.exceptions.LivroException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(LivroException.class)
	public ResponseEntity<Void> handleBookException(LivroException e, HttpServletRequest request){
		
		return ResponseEntity.notFound().build();
				
	}
	
}
