package com.aluracursos.literalura_challenge.repository;

import com.aluracursos.literalura_challenge.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    //Query JPQL
    @Query("SELECT a FROM Autor a WHERE a.fechaMuerte >= :anio")
    List<Autor> AutorPorAnio(String anio);
}
