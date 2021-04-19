package com.curso.socialbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.socialbook.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
