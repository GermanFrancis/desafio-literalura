package com.aluracursos.literalura_challenge.repository;

import com.aluracursos.literalura_challenge.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
