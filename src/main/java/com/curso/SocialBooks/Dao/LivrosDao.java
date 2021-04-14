package com.curso.SocialBooks.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curso.SocialBooks.Informacoes.Livro;

public interface LivrosDao extends JpaRepository<Livro, Long>{

	
	
}
