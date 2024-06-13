package com.aluracursos.literalura_challenge.main;
import com.aluracursos.literalura_challenge.exception.InvalidMenuOptionException;
import com.aluracursos.literalura_challenge.repository.AutorRepository;
import com.aluracursos.literalura_challenge.repository.LibroRepository;
import com.aluracursos.literalura_challenge.util.LibroUtil;
import com.aluracursos.literalura_challenge.util.MenuUtil;

import java.util.Scanner;

public class Principal {

    @SuppressWarnings("resource")
    public void menu(LibroRepository libroRepository, AutorRepository autorRepository) {
        Scanner inputkeyboard = new Scanner(System.in);
        LibroUtil util = new LibroUtil(libroRepository,autorRepository);
        MenuUtil menu = new MenuUtil();
        int opcion = 0;
        while (opcion != 6) {
            try {
                opcion = menu.mostrarMenu();
                switch (opcion) {
                    case 1 -> util.guardarLibro(); // [1] Buscar libro por título
                    case 2 -> util.listarLibrosRegistrados(); // [2] Listar libros registrados
                    case 3 -> util.listarLibrosPorIdioma(); // [3] Listar libros por idioma
                    case 4 -> util.listarAutoresRegistrados(); // [4] Listar autores registrados
                    case 5 -> util.listarAutoresVivosPorAnio(); // [5] Listar autores vivos por año
                    case 6 -> System.out.println("Cerrando la aplicación..."); // [6] Salir
                    default -> throw new InvalidMenuOptionException("La opción [" + opcion + "] no existe");
                }
            }catch (NumberFormatException | InvalidMenuOptionException i) {
                System.out.println("Opción no válida, " + i.getMessage());
            }
        }
    }
}
