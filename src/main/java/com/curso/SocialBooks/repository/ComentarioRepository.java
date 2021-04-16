package com.curso.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.socialbooks.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
