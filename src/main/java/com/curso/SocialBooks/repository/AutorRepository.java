package com.curso.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.socialbooks.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
