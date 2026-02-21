package com.pedroviel.sistema_de_cadastro.infrastructure.repository;

import com.pedroviel.sistema_de_cadastro.infrastructure.entity.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CadastroRepository extends JpaRepository<Cadastro, UUID> {
    Cadastro findByNomeAlunoAndCursoAluno(String nomeAluno, String cursoAluno);
    List<Cadastro> findByCursoAluno(String cursoAluno);
}
