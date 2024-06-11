package com.aluracursos.literalura_challenge.main;

import com.aluracursos.literalura_challenge.exception.InvalidMenuOptionException;
import com.aluracursos.literalura_challenge.model.Datos;
import com.aluracursos.literalura_challenge.repository.LibroRepository;
import com.aluracursos.literalura_challenge.service.APIService;
import com.aluracursos.literalura_challenge.util.ConversionDatos;
import com.aluracursos.literalura_challenge.util.LibroUtil;

import java.util.Scanner;

public class Principal {

    public void menu(LibroRepository repositorio) {
        Scanner inputkeyboard = new Scanner(System.in);
        APIService apiservice = new APIService();
        ConversionDatos conversor = new ConversionDatos();
        String URL_BASE = "http://gutendex.com/books/";
        LibroUtil util = new LibroUtil(repositorio);

        int opcion = 0;
        while (opcion != 7) {
            try {
                System.out.print("""
                        _______________________________________
                        |      Bienvenido/a a Literalura      |
                        |--------------OPCIONES---------------|
                        |    [1] Buscar libro por título      |
                        |    [2] Listar libros registrados    |
                        |    [3] Listar libros por idioma     |
                        |    [4] Listar autores registrados   |
                        |    [5] Listar autores vivos por año |
                        |    [6] Salir                        |
                        |-------------------------------------|
                        Seleccione una opción
                        """);
                System.out.print("-> ");
                opcion = Integer.parseInt(inputkeyboard.nextLine());
                switch (opcion) {
                    case 1:
                        util.guardarLibro();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        throw new InvalidMenuOptionException("La opción [" + opcion + "] no existe");
                }
            }catch (NumberFormatException | InvalidMenuOptionException i) {
                System.out.println("Opción no válida, " + i.getMessage());
            }
        }
    }
}
