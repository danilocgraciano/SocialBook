package com.curso.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.socialbooks.information.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

	
}
