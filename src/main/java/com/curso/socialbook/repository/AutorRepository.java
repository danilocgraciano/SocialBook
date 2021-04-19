package com.curso.socialbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.socialbook.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
