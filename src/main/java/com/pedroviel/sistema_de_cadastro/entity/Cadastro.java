package com.pedroviel.sistema_de_cadastro.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@Entity
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cadastro")
public class Cadastro {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID matriculaAluno;
    private String nomeAluno;
    private String cursoAluno;
}
