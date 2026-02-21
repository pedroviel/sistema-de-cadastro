package com.pedroviel.sistema_de_cadastro.controller;

import com.pedroviel.sistema_de_cadastro.infrastructure.entity.Cadastro;
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

    @PostMapping
    public ResponseEntity<Cadastro> cadastrarAluno(@RequestBody Cadastro cadastro) {
        return ResponseEntity.accepted().body(cadastroService.cadastrarAluno(cadastro));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAluno(@RequestParam UUID matriculaAluno) {
        cadastroService.deletarAluno(matriculaAluno);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cadastro>> listarAlunosPorCurso(@RequestParam String cursoAluno) {
        return ResponseEntity.ok().body(cadastroService.listarAlunosPorCurso(cursoAluno));
    }

    @PutMapping
    public ResponseEntity<Cadastro> alterarCadastroAluno(@RequestBody Cadastro cadastro, @RequestParam String nomeAluno, @RequestParam String cursoAluno) {
        return ResponseEntity.accepted().body(cadastroService.alterarCadastroAluno(cadastro, nomeAluno, cursoAluno));
    }
}
