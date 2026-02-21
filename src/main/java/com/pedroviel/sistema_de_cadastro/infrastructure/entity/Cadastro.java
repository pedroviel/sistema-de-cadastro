package com.pedroviel.sistema_de_cadastro.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cadastro")
public class Cadastro {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID matriculaAluno;
    private String nomeAluno;
    private String emailAluno;
    private String cursoAluno;
    private int idadeAluno;
    private LocalDateTime dataDeCadastroAluno = LocalDateTime.now();
}
