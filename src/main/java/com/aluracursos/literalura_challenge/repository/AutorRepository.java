package com.aluracursos.literalura_challenge.repository;

import com.aluracursos.literalura_challenge.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
