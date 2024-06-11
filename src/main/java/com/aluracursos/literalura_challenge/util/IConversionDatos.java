package com.aluracursos.literalura_challenge.util;

public interface IConversionDatos {
    //Función de datos genéricos
    <T> T obtenerDatos(String json, Class<T> clase);
}
