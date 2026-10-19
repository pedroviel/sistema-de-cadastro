package com.pedroviel.sistema_de_cadastro.exception;

public class StudentAlreadyEnrolledException extends RuntimeException {
    public StudentAlreadyEnrolledException()
    {
        super("Aluno já matriculado no curso!");
    }
}
