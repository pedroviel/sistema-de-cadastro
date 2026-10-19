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

        return new CadastroDTO(cadastro.getMatriculaAluno(), cadastro.getNomeAluno(), cadastro.getCursoAluno());
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

        return new Cadastro(dto.matriculaAluno(), dto.nomeAluno(), dto.cursoAluno());
    }
}
