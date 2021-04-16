package com.curso.socialbooks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.curso.socialbooks.domain.Autor;
import com.curso.socialbooks.exceptions.AutorException;
import com.curso.socialbooks.exceptions.AutorNotFindException;
import com.curso.socialbooks.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;


	public List<Autor> list(){

		return autorRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Autor save(@RequestBody Autor autor){
		//autor.setId(Long.valueOf(	10l));
		//autor.setId(Long.valueOf("10"));
		//autor.setId("10l");

		if(autor.getId() != null){
			Optional<Autor> autorAux = autorRepository.findById(autor.getId());

			if(autorAux != null) { 
				throw new AutorException("O autor ja existe.");
			}
		}

		return autorRepository.save(autor);

	}


	public Optional<Autor> search(Long id) {

		Optional<Autor> autor = autorRepository.findById(id);		

		if(autor == null) {
			throw new AutorNotFindException("Autor não encontrado");
		}

		return autor;
	}


}
