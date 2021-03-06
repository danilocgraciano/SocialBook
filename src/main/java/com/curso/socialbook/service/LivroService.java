package com.curso.socialbook.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.socialbook.domain.Comentario;
import com.curso.socialbook.domain.Livro;
import com.curso.socialbook.exceptions.LivroException;
import com.curso.socialbook.repository.ComentarioRepository;
import com.curso.socialbook.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livrosRepository;
	
	@Autowired
	private ComentarioRepository comentariosRepository;

	private Optional<Livro> livro;

	public List<Livro> list(){
		return livrosRepository.findAll();
	}
	
	public Optional<Livro> search(long id) {
		
		Optional<Livro> livro = livrosRepository.findById(id);
		
		if(livro.isEmpty()) {
			throw new LivroException("O livro não foi encontrado. Id : " + id);
		}
		
		return livro;
	}
	
	
	public Livro save(Livro livro) {
		
		livro.setId(null);
		return livrosRepository.save(livro);
		
	}
	
	public Livro delete(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (LivroException e) {
			throw new LivroException("O livro não foi encontrado. Id : " + id);
		}
		
		return null;
	}
	
	public void update(Livro livro) {
		ifExist(livro);
		livrosRepository.save(livro);
	}
	
	private void ifExist(Livro livro) {
		search(livro.getId());
	}
	
	public Comentario commentSave(Long livroId, Comentario comment) {
		
		livro = search(livroId);
		comment.setData(new Date());
		comment.setLivro(livro.get());
		
		//comment.setLivro(livroId);
		
		return comentariosRepository.save(comment);
	}
	
	public List<Comentario> commentList(Long livroId){
		
		livro = search(livroId);	
		return livro.get().getComentario();
	}
	
}
