package br.com.fiap.restaurante.gestao.mapper;

import br.com.fiap.restaurante.gestao.domain.model.Endereco;
import br.com.fiap.restaurante.gestao.domain.model.Usuario;
import br.com.fiap.restaurante.gestao.presentation.dto.EnderecoDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "login", source = "login")
    @Mapping(target = "senha", source = "senha")
    @Mapping(target = "enderecos", source = "enderecos")
    Usuario toEntity(UsuarioDTO dto);
    UsuarioDTO toDto(Usuario entity);
    UsuarioResponseDTO toResponseDto(Usuario entity);

    Endereco toEnderecoEntity(EnderecoDTO dto);
    EnderecoDTO toEnderecoDto(Endereco entity);

    List<Endereco> toEnderecoEntityList(List<EnderecoDTO> dtos);
    List<EnderecoDTO> toEnderecoDtoList(List<Endereco> entities);
}
