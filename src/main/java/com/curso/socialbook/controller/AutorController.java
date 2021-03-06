package com.curso.socialbook.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.socialbook.domain.Autor;
import com.curso.socialbook.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorService autorService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Autor>> list(){
		return ResponseEntity.status(HttpStatus.OK).body(autorService.list());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Autor> save(@Valid @RequestBody Autor autor){

		autor = autorService.save(autor);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
							.path("/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<Autor>> search(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(autorService.search(id));
	}

}