package com.curso.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.socialbooks.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	
}
