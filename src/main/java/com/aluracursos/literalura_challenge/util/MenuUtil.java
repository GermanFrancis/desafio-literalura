package com.aluracursos.literalura_challenge.util;

import java.util.Scanner;

public class MenuUtil {
    public final Scanner inputkeyboard = new Scanner(System.in);
    public int mostrarMenu() {
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
        return Integer.parseInt(inputkeyboard.nextLine());
    }
}
