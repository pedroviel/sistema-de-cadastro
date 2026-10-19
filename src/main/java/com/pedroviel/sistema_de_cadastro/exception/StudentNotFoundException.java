package com.pedroviel.sistema_de_cadastro.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException()
    {
        super("Aluno não encontrado!");
    }
}
