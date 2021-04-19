package com.curso.socialbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.socialbook.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	
}
