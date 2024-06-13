package com.aluracursos.literalura_challenge.repository;

import com.aluracursos.literalura_challenge.model.Autor;
import com.aluracursos.literalura_challenge.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
