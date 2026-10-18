package com.pedroviel.sistema_de_cadastro.mapper;

import com.pedroviel.sistema_de_cadastro.controller.dto.CadastroDTO;
import com.pedroviel.sistema_de_cadastro.entity.Cadastro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastroMapper {

    public CadastroDTO toDTO(Cadastro cadastro) {

        if(cadastro == null) {
            return null;
        }

        CadastroDTO dto = new CadastroDTO();

        dto.setMatriculaAluno(cadastro.getMatriculaAluno());
        dto.setNomeAluno(cadastro.getNomeAluno());
        dto.setCursoAluno(cadastro.getCursoAluno());

        return dto;
    }

    public List<CadastroDTO> toDTOList(List<Cadastro> cadastros) {

        if(cadastros == null) {
            return null;
        }

        return cadastros.stream().map(this::toDTO).toList();
    }

    public Cadastro toEntity(CadastroDTO dto) {

        if(dto == null) {
            return null;
        }

        Cadastro cadastro = new Cadastro();

        cadastro.setMatriculaAluno(dto.getMatriculaAluno());
        cadastro.setNomeAluno(dto.getNomeAluno());
        cadastro.setCursoAluno(dto.getCursoAluno());

        return cadastro;
    }
}
