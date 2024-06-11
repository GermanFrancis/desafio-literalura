package com.aluracursos.literalura_challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name="Libros")
public class Libro {
    @Id
    private Long id;
    @Column(unique = true)
    private String titulo;
    //@OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private List<DatosAutor> autor;
    private String idioma;
    private Double numeroDescargas;

    public Libro(){}

    public Libro(DatosLibros datoslibro){
        this.id = datoslibro.id();
        this.titulo = datoslibro.titulo();
        this.idioma = String.valueOf(datoslibro.idioma().getFirst());
        this.numeroDescargas = OptionalDouble.of(Double.parseDouble(String.valueOf(datoslibro.numeroDescargas()))).orElse(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }
}
