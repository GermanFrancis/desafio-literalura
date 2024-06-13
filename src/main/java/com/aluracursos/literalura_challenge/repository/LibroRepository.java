package com.aluracursos.literalura_challenge.repository;

import com.aluracursos.literalura_challenge.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    //Derived queries
    List<Libro> findByIdioma(String idioma);
    Optional<Libro> findByTitulo(String titulo);
}
