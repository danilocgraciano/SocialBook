package com.curso.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.curso.socialbooks.domain.DetailError;
import com.curso.socialbooks.exceptions.AutorException;
import com.curso.socialbooks.exceptions.AutorNotFindException;
import com.curso.socialbooks.exceptions.LivroException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(LivroException.class)
	public ResponseEntity<DetailError> handleBookException(LivroException e, HttpServletRequest request){

		DetailError error = new DetailError();
		error.setStatus(404l);
		error.setTitle("Livro não encontrado");
		error.setDevelopermessage("https:/Error.com.br");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}
	
	@ExceptionHandler(AutorException.class)
	public ResponseEntity<DetailError> handleAutorException(AutorException e, HttpServletRequest request){

		DetailError error = new DetailError();
		error.setStatus(409l);
		error.setTitle("Autor ja cadasrtrado");
		error.setDevelopermessage("https:/Error.com.br");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	@ExceptionHandler(AutorNotFindException.class)
	public ResponseEntity<DetailError> handleAutorCadastradoException(AutorException e, HttpServletRequest request){

		DetailError error = new DetailError();
		error.setStatus(404l);
		error.setTitle("Autor não encontrado");
		error.setDevelopermessage("https:/Error.com.br");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

}
