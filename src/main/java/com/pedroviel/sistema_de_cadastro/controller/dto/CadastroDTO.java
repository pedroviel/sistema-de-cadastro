package com.pedroviel.sistema_de_cadastro.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CadastroDTO {
    private UUID matriculaAluno;
    private String nomeAluno;
    private String cursoAluno;
}
