package com.aluracursos.literalura_challenge.model;
import jakarta.persistence.*;
import java.util.OptionalDouble;

@Entity
@Table(name="Libros")
public class Libro {
    @Id
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
    private String nombreAutor;
    private String idioma;
    private Double numeroDescargas;

    public Libro(){}

    public Libro(DatosLibros datoslibro, Autor autor){
        this.id = datoslibro.id();
        this.titulo = datoslibro.titulo();
        this.autor = autor;
        this.nombreAutor = autor.getNombre();
        this.idioma = String.valueOf(datoslibro.idioma().getFirst());
        this.numeroDescargas = OptionalDouble.of(Double.parseDouble(String.valueOf(datoslibro.numeroDescargas()))).orElse(0);
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    @Override
    public String toString() {
        return "---------------LIBRO---------------" + "\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + nombreAutor + "\n" +
                "Idioma: " + idioma + "\n" +
                "Número de descargas: " + numeroDescargas + "\n" +
                "----------------------------------" + "\n";
    }
}
