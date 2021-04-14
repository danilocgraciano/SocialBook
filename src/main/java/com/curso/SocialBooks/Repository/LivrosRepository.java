package com.curso.SocialBooks.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curso.SocialBooks.Informacoes.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

	
}
