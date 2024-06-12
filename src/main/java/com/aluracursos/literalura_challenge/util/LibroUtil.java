package com.aluracursos.literalura_challenge.util;
import com.aluracursos.literalura_challenge.model.*;
import com.aluracursos.literalura_challenge.repository.AutorRepository;
import com.aluracursos.literalura_challenge.repository.LibroRepository;
import com.aluracursos.literalura_challenge.service.APIService;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibroUtil {
    public final Scanner inputkeyboard = new Scanner(System.in);
    private final APIService apiservice = new APIService();
    private final ConversionDatos conversor = new ConversionDatos();
    private final LibroRepository librorepo;
    private final AutorRepository autorrepo;
    public String URL_BASE = "http://gutendex.com/books/";

    public LibroUtil(LibroRepository libroRepository, AutorRepository autorRepository){
        this.autorrepo = autorRepository;
        this.librorepo = libroRepository;
    }

    public Datos buscarLibroPorTitulo(){
        System.out.print("Libro a buscar: ");
        var libroBuscado = inputkeyboard.nextLine();
        try{
            var json = apiservice.obtenerDatos(URL_BASE + "?search=" + libroBuscado.replace(" ","+").toLowerCase());
            return conversor.obtenerDatos(json, Datos.class);
        }catch (NoSuchElementException e){
            System.out.println("\nNo se encontró el libro [" + libroBuscado + "]");
            return null;
        }
    }

    public void guardarLibro(){
        Datos datos = buscarLibroPorTitulo();
        if (datos != null) {
            DatosLibros datoslibro = datos.resultados().getFirst();
            DatosAutor datosautor = datoslibro.autor().getFirst();
            Autor autor = new Autor(datosautor);
            Libro libro = new Libro(datoslibro,autor);
            autorrepo.save(autor);
            librorepo.save(libro);
            System.out.println(libro);
        }
    }
}
