package com.curso.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.socialbooks.exceptions.LivroException;
import com.curso.socialbooks.information.Livro;
import com.curso.socialbooks.repository.LivrosRepository;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;

	public List<Livro> List(){
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
	
	public Livro Delete(Long id) {
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
	
	
	
}
