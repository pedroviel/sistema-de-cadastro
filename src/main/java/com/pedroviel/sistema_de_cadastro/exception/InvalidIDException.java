package com.pedroviel.sistema_de_cadastro.exception;

public class InvalidIDException extends RuntimeException {
    public InvalidIDException()
    {
        super("Matrícula inválida!");
    }
}
