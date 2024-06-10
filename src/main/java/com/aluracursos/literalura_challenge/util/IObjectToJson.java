package com.aluracursos.literalura_challenge.util;

public interface IObjectToJson {
    //Función de datos genéricos
    <T> T getData(String json, Class<T> clase);
}
