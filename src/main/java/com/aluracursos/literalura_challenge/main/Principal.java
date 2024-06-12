package com.aluracursos.literalura_challenge.main;
import com.aluracursos.literalura_challenge.exception.InvalidMenuOptionException;
import com.aluracursos.literalura_challenge.repository.AutorRepository;
import com.aluracursos.literalura_challenge.repository.LibroRepository;
import com.aluracursos.literalura_challenge.util.LibroUtil;
import java.util.Scanner;

public class Principal {

    @SuppressWarnings("resource")
    public void menu(LibroRepository libroRepository, AutorRepository autorRepository) {
        Scanner inputkeyboard = new Scanner(System.in);
        LibroUtil util = new LibroUtil(libroRepository,autorRepository);

        int opcion = 0;
        while (opcion != 6) {
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
