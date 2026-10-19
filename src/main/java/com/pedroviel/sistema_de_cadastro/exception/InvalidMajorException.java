package com.pedroviel.sistema_de_cadastro.exception;

public class InvalidMajorException extends RuntimeException {
    public InvalidMajorException()
    {
        super("Curso inválido!");
    }
}
