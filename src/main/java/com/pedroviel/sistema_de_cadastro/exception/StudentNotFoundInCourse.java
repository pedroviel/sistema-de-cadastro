package com.pedroviel.sistema_de_cadastro.exception;

public class StudentNotFoundInCourse extends RuntimeException {
    public StudentNotFoundInCourse()
    {
        super("Não há alunos cadastrados no curso!");
    }
}
