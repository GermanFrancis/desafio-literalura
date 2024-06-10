package com.aluracursos.literalura_challenge.exception;

public class InvalidMenuOptionException extends Exception {
    private final String message;

    public InvalidMenuOptionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}