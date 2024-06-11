package com.aluracursos.literalura_challenge.util;

import com.aluracursos.literalura_challenge.model.Datos;
import com.aluracursos.literalura_challenge.model.DatosLibros;
import com.aluracursos.literalura_challenge.model.Libro;
import com.aluracursos.literalura_challenge.repository.LibroRepository;
import com.aluracursos.literalura_challenge.service.APIService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibroUtil {
    public final Scanner inputkeyboard = new Scanner(System.in);
    private final APIService apiservice = new APIService();
    private final ConversionDatos conversor = new ConversionDatos();
    private final LibroRepository repositorio;
    public String URL_BASE = "http://gutendex.com/books/";

    public LibroUtil(LibroRepository repository){
        this.repositorio = repository;
    }

    public DatosLibros buscarLibroPorTitulo(){
        System.out.println("Nombre del libro a buscar:");
        var libroBuscado = inputkeyboard.nextLine();
        try{
            var json = apiservice.obtenerDatos(URL_BASE + "?search=" + libroBuscado.replace(" ","+").toLowerCase());
            var datosBusqueda = conversor.obtenerDatos(json, Datos.class).resultados();
            return datosBusqueda.getFirst();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public void guardarLibro(){
        DatosLibros datos = buscarLibroPorTitulo();
        if (datos == null) {
            System.out.println("No se encontró el libro");
        }else{
            Libro libro = new Libro(datos);
            System.out.println(libro.getTitulo());
            repositorio.save(libro);
        }
    }
}
