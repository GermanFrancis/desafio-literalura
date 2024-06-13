package com.aluracursos.literalura_challenge.util;
import com.aluracursos.literalura_challenge.model.*;
import com.aluracursos.literalura_challenge.record.Datos;
import com.aluracursos.literalura_challenge.record.DatosAutor;
import com.aluracursos.literalura_challenge.record.DatosLibros;
import com.aluracursos.literalura_challenge.repository.AutorRepository;
import com.aluracursos.literalura_challenge.repository.LibroRepository;
import com.aluracursos.literalura_challenge.service.APIService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibroUtil {
    public final Scanner inputkeyboard = new Scanner(System.in);
    private final APIService apiservice = new APIService();
    private final ConversionDatos conversor = new ConversionDatos();
    private final LibroRepository librorepo;
    private final AutorRepository autorrepo;
    private List<Libro> librosBuscados;
    private List<Autor> autores;
    public String URL_BASE = "http://gutendex.com/books/";

    public LibroUtil(LibroRepository libroRepository, AutorRepository autorRepository){
        this.autorrepo = autorRepository;
        this.librorepo = libroRepository;
    }

    public Datos buscarLibroPorTitulo(){
        System.out.print("Libro a buscar: ");
        var libroBuscado = inputkeyboard.nextLine();
        var json = apiservice.obtenerDatos(URL_BASE + "?search=" + libroBuscado.replace(" ","+").toLowerCase());
        return conversor.obtenerDatos(json, Datos.class);
    }

    public void guardarLibro(){
        Datos datos = buscarLibroPorTitulo();
        if (!datos.resultados().isEmpty()) {
            DatosLibros datoslibro = datos.resultados().getFirst();
            DatosAutor datosautor = datoslibro.autor().getFirst();
            Autor autor = new Autor(datosautor);
            Libro libro = new Libro(datoslibro,autor);
            autorrepo.save(autor);
            librorepo.save(libro);
            System.out.println(libro);
        }else{
            System.out.println("Libro no encontrado");
        }
    }

    public void listarLibrosRegistrados() {
        librosBuscados = librorepo.findAll();
        librosBuscados.forEach(System.out::println);
    }

    public void listarLibrosPorIdioma() {
        System.out.println("""
                [es] - español
                [en] - inglés
                [fr] - frances
                [pt] - portugues
                """);
        System.out.print("Idioma a buscar: ");
        var idiomaBuscado = inputkeyboard.nextLine();
        librosBuscados = librorepo.findByIdioma(idiomaBuscado);
        librosBuscados.forEach(System.out::println);
    }

    public void listarAutoresRegistrados() {
        autores = autorrepo.findAll();
        autores.forEach(System.out::println);
    }

    public void listarAutoresVivosPorAnio() {

    }
}
