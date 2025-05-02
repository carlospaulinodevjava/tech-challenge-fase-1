package br.com.fiap.restaurante.gestao.mapper;

import br.com.fiap.restaurante.gestao.domain.model.Endereco;
import br.com.fiap.restaurante.gestao.domain.model.Usuario;
import br.com.fiap.restaurante.gestao.presentation.dto.EnderecoDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity(UsuarioDTO dto);
    UsuarioDTO toDto(Usuario entity);

    Endereco toEnderecoEntity(EnderecoDTO dto);
    EnderecoDTO toEnderecoDto(Endereco entity);

    List<Endereco> toEnderecoEntityList(List<EnderecoDTO> dtos);
    List<EnderecoDTO> toEnderecoDtoList(List<Endereco> entities);
}
