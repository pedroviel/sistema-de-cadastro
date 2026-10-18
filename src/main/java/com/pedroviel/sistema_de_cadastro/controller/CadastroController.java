package com.pedroviel.sistema_de_cadastro.controller;

import com.pedroviel.sistema_de_cadastro.controller.dto.CadastroDTO;
import com.pedroviel.sistema_de_cadastro.entity.Cadastro;
import com.pedroviel.sistema_de_cadastro.mapper.CadastroMapper;
import com.pedroviel.sistema_de_cadastro.service.CadastroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cadastros")
@RequiredArgsConstructor
public class CadastroController {

    private final CadastroService cadastroService;
    private final CadastroMapper cadastroMapper;

    @PostMapping
    public ResponseEntity<CadastroDTO> cadastrarAluno(@RequestBody CadastroDTO cadastroDTO) {

        Cadastro cadastro = cadastroMapper.toEntity(cadastroDTO);
        Cadastro cadastroSalvo = cadastroService.cadastrarAluno(cadastro);

        return ResponseEntity.accepted().body(cadastroMapper.toDTO(cadastroSalvo));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAluno(@RequestParam UUID matriculaAluno) {
        cadastroService.deletarAluno(matriculaAluno);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CadastroDTO>> listarAlunosPorCurso(@RequestParam String cursoAluno) {

        List<Cadastro> cadastro = cadastroService.listarAlunosPorCurso(cursoAluno);

        return ResponseEntity.ok().body(cadastroMapper.toDTOList(cadastro));
    }

    @GetMapping("/{matriculaAluno}")
    public ResponseEntity<CadastroDTO> buscarAlunoPorMatricular(@PathVariable UUID matriculaAluno) {

        Cadastro cadastro = cadastroService.buscarAlunoPorMatricula(matriculaAluno);

        return ResponseEntity.ok().body(cadastroMapper.toDTO(cadastro));
    }

    @PutMapping
    public ResponseEntity<CadastroDTO> alterarCadastroAluno(@RequestParam String nomeAluno, @RequestParam String cursoAluno) {

        Cadastro cadastro = cadastroService.alterarCadastroAluno(nomeAluno, cursoAluno);
        return ResponseEntity.accepted().body(cadastroMapper.toDTO(cadastro));
    }
}
