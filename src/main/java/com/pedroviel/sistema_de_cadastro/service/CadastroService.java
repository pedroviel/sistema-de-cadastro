package com.pedroviel.sistema_de_cadastro.service;

import com.pedroviel.sistema_de_cadastro.infrastructure.entity.Cadastro;
import com.pedroviel.sistema_de_cadastro.infrastructure.repository.CadastroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastroService {

    private final CadastroRepository cadastroRepository;

    public Cadastro cadastrarAluno(Cadastro cadastro) {

        Cadastro cadastros = cadastroRepository.findByNomeAlunoAndCursoAluno(cadastro.getNomeAluno(), cadastro.getCursoAluno());

        if (Objects.nonNull(cadastros)) {
            throw new RuntimeException("Aluno já matriculado no curso!");
        }
        return cadastroRepository.save(cadastro);
    }

    public void deletarAluno(UUID matriculaAluno) {

        if(!cadastroRepository.existsById(matriculaAluno)){
            throw new RuntimeException("Matrícula inválida!");
        }

        cadastroRepository.deleteById(matriculaAluno);
    }

    public List<Cadastro> listarAlunosPorCurso(String cursoAluno) {

        List<Cadastro> cadastros = cadastroRepository.findByCursoAluno(cursoAluno);

        if(cadastros.isEmpty()){
            throw new RuntimeException("Não há alunos cadastrados no curso!");
        }

        return cadastros;
    }

    public Cadastro alterarCadastroAluno(Cadastro cadastro, String nomeAluno, String cursoAluno) {

        Cadastro cadastros = cadastroRepository.findByNomeAluno(nomeAluno);

        if (Objects.isNull(cadastros)) {
            throw new RuntimeException("Aluno não encontrado!");
        }

        cadastro.setMatriculaAluno(cadastros.getMatriculaAluno());
        cadastro.setCursoAluno(cursoAluno);
        return cadastroRepository.save(cadastro);
    }


}
