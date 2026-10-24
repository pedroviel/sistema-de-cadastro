package com.pedroviel.sistema_de_cadastro.api.repository;

import com.pedroviel.sistema_de_cadastro.entity.Cadastro;
import com.pedroviel.sistema_de_cadastro.repository.CadastroRepository;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CadastroRepositoryTests {

    @Autowired
    private CadastroRepository cadastroRepository;

    @Test
    public void findByNomeAlunoAndCursoAluno_DeveRetornarONomeECursoCadastrados() {

        //Arrange
        Cadastro cadastro = Cadastro.builder()
                .nomeAluno("Pedro")
                .cursoAluno("Engenharia da Computação").build();

        //Act
        cadastroRepository.save(cadastro);
        Cadastro pesquisarPeloAlunoECurso = cadastroRepository.findByNomeAlunoAndCursoAluno(cadastro.getNomeAluno(), cadastro.getCursoAluno());

        //Assert
        Assertions.assertThat(pesquisarPeloAlunoECurso).isNotNull();
        Assertions.assertThat(pesquisarPeloAlunoECurso.getNomeAluno()).isEqualTo("Pedro");
        Assertions.assertThat(pesquisarPeloAlunoECurso.getCursoAluno()).isEqualTo("Engenharia da Computação");
    }

    @Test
    public void findByNomeAluno_DeveRetornarOObjetoDoAlunoPesquisadoPeloNome() {

        //Arrange
        Cadastro cadastro = Cadastro.builder()
                .nomeAluno("Pedro")
                .cursoAluno("Engenharia da Computação").build();

        //Act
        cadastroRepository.save(cadastro);
        Cadastro pesquisarAlunoPeloNome = cadastroRepository.findByNomeAluno(cadastro.getNomeAluno());

        //Assert
        Assertions.assertThat(pesquisarAlunoPeloNome).isNotNull();
        Assertions.assertThat(pesquisarAlunoPeloNome.getNomeAluno()).isEqualTo("Pedro");
        Assertions.assertThat(pesquisarAlunoPeloNome.getCursoAluno()).isEqualTo("Engenharia da Computação");
    }

    @Test
    public void findByMatriculaAluno_DeveRetornarOObjetoDoAlunoPesquisadoPelaMatricula() {

        //Arrange
        Cadastro cadastro = Cadastro.builder()
                .nomeAluno("Pedro")
                .cursoAluno("Engenharia da Computação").build();

        //Act
        cadastroRepository.save(cadastro);
        Cadastro pesquisarAlunoPelaMatricula = cadastroRepository.findByMatriculaAluno(cadastro.getMatriculaAluno());

        //Assert
        Assertions.assertThat(pesquisarAlunoPelaMatricula).isNotNull();
        Assertions.assertThat(pesquisarAlunoPelaMatricula.getNomeAluno()).isEqualTo("Pedro");
        Assertions.assertThat(pesquisarAlunoPelaMatricula.getCursoAluno()).isEqualTo("Engenharia da Computação");
    }

    @Test
    public void findByCursoAluno_DeveExibirApenasAlunosDoCursoEspecificado() {

        //Arrange
        Cadastro cadastro = Cadastro.builder()
                .nomeAluno("Pedro")
                .cursoAluno("Engenharia da Computação").build();
        Cadastro cadastro2 = Cadastro.builder()
                .nomeAluno("Viel")
                .cursoAluno("Administração").build();

        //Act
        cadastroRepository.save(cadastro);
        cadastroRepository.save(cadastro2);
        List<Cadastro> alunosNoCurso = cadastroRepository.findByCursoAluno(cadastro.getCursoAluno());

        //Assert
        Assertions.assertThat(alunosNoCurso).isNotNull();
        Assertions.assertThat(alunosNoCurso.get(0).getNomeAluno()).isEqualTo("Pedro");
        Assertions.assertThat(alunosNoCurso.get(0).getCursoAluno()).isEqualTo("Engenharia da Computação");
    }

    @Test
    public void existsByCursoAluno_DeveRetornarTrue() {

        //Arrange
        Cadastro cadastro = Cadastro.builder()
                .nomeAluno("Pedro")
                .cursoAluno("Engenharia da Computação").build();

        //Act
        cadastroRepository.save(cadastro);
        boolean cursoExiste = cadastroRepository.existsByCursoAluno(cadastro.getCursoAluno());

        //Assert
        Assertions.assertThat(cursoExiste).isTrue();
    }
}
