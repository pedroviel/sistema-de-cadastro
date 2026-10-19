package com.pedroviel.sistema_de_cadastro.service;

import com.pedroviel.sistema_de_cadastro.entity.Cadastro;
import com.pedroviel.sistema_de_cadastro.exception.*;
import com.pedroviel.sistema_de_cadastro.repository.CadastroRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastroService {

    private final CadastroRepository cadastroRepository;

    @NonNull
    public Cadastro cadastrarAluno(Cadastro cadastro) {

        String nomeAluno = cadastro.getNomeAluno();
        String cursoAluno = cadastro.getCursoAluno();

        Cadastro cadastros = cadastroRepository.findByNomeAlunoAndCursoAluno(nomeAluno, cursoAluno);

        if (Objects.nonNull(cadastros)) {
            throw new StudentAlreadyEnrolledException();
        }

        System.out.println(nomeAluno + " cadastrado com sucesso!");
        return cadastroRepository.save(cadastro);
    }

    public void deletarAluno(UUID matriculaAluno) {

        if(!cadastroRepository.existsById(matriculaAluno)){
            throw new InvalidIDException();
        }

        String nomeAluno = cadastroRepository.findById(matriculaAluno).get().getNomeAluno();

        cadastroRepository.deleteById(matriculaAluno);
        System.out.println(nomeAluno + " deletado com sucesso!");
    }

    public List<Cadastro> listarAlunosPorCurso(String cursoAluno) {

        if(!cadastroRepository.existsByCursoAluno(cursoAluno)){
            throw new InvalidMajorException();
        }

        List<Cadastro> cadastros = cadastroRepository.findByCursoAluno(cursoAluno);

        if(cadastros.isEmpty()){
            throw new StudentNotFoundInCourse();
        }

        return cadastros;
    }

    public Cadastro alterarCadastroAluno(String nomeAluno, String cursoAluno) {

        Cadastro alunoCadastrado = cadastroRepository.findByNomeAluno(nomeAluno);

        if (Objects.isNull(alunoCadastrado)) {
            throw new StudentNotFoundException();
        }

        alunoCadastrado.setCursoAluno(cursoAluno);

        return cadastroRepository.save(alunoCadastrado);
    }

    public Cadastro buscarAlunoPorMatricula(UUID matriculaAluno) {
        if(!cadastroRepository.existsById(matriculaAluno)){
            throw new StudentNotFoundException();
        }

        return cadastroRepository.findByMatriculaAluno(matriculaAluno);
    }
}
