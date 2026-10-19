package com.pedroviel.sistema_de_cadastro.controller.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;
public record CadastroDTO (

        UUID matriculaAluno,

        @NotBlank
        String nomeAluno,

        @NotBlank
        String cursoAluno
){}
