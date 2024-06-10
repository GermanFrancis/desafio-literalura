package com.aluracursos.literalura_challenge.main;

import com.aluracursos.literalura_challenge.exception.InvalidMenuOptionException;
import com.aluracursos.literalura_challenge.model.Datos;
import com.aluracursos.literalura_challenge.service.APIService;
import com.aluracursos.literalura_challenge.util.ObjectToJson;

import java.util.Scanner;

public class Principal {

    public void menu() {
        APIService apiservice = new APIService();
        ObjectToJson objecttojson = new ObjectToJson();
        Scanner inputkeyboard = new Scanner(System.in);

        var json = apiservice.getData();
        System.out.println(json);
        var data = objecttojson.getData(json, Datos.class);
        System.out.println(data);

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
                if (opcion < 1 || opcion > 7) {
                    throw new InvalidMenuOptionException("Opción no válida. Por favor selecciona una opción entre 1 y 7.");
                }
            }catch (NumberFormatException e) {
                System.out.println("Opción no valida" + e.getMessage());
            }catch (InvalidMenuOptionException i){
                System.out.println(i.getMessage());
            }
        }
    }
}
