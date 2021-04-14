package com.curso.socialbooks.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.socialbooks.information.Livro;
import com.curso.socialbooks.services.LivrosService;


@RestController
@RequestMapping("/livros")
public class LivrosController {
	
	@Autowired
	private LivrosService livrosService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.List());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Livro livro) {
		
		livro = livrosService.save(livro);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}").buildAndExpand(livro.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<?> search (@PathVariable("id") Long id) {
		
		Optional<Livro> livro = livrosService.search(id);
		return ResponseEntity.status(HttpStatus.OK).body(livro);
		 
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		
		livrosService.Delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Livro livro, @PathVariable("id") Long id){
		
		livro.setId(id);
		livrosService.update(livro);
		return ResponseEntity.noContent().build();
		
	}
	
}
