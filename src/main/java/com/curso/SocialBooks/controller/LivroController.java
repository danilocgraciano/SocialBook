package com.curso.socialbooks.controller;

import java.net.URI;
import java.util.List;

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

import com.curso.socialbooks.domain.Comentario;
import com.curso.socialbooks.domain.Livro;
import com.curso.socialbooks.service.LivroService;


@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	private LivroService livrosService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.List());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@Valid @RequestBody Livro livro) {
		
		livro = livrosService.save(livro);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}").buildAndExpand(livro.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<?> search (@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.search(id));
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
	
	@RequestMapping(value = "/{id}/comentarios", method = RequestMethod.POST)
	public ResponseEntity<Void> commentAdd(@PathVariable("id") Long livroId,@RequestBody Comentario comentario) {
		livrosService.commentSave(livroId, comentario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}/comentarios", method = RequestMethod.GET)
	public ResponseEntity<List<Comentario>> commentList(@PathVariable("id") Long livroId){
		
		List<Comentario> comment = livrosService.commentList(livroId);
		
		return ResponseEntity.status(HttpStatus.OK).body(comment);
	}
	
}
