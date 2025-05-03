package br.com.fiap.restaurante.gestao.mapper;

import br.com.fiap.restaurante.gestao.domain.model.Endereco;
import br.com.fiap.restaurante.gestao.domain.model.Usuario;
import br.com.fiap.restaurante.gestao.presentation.dto.EnderecoDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
     UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

     // Mapeia DTO -> Entidade
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "login", source = "login")
    @Mapping(target = "senha", source = "senha")
    @Mapping(target = "tipoUsuario", source = "tipoUsuario")
    @Mapping(target = "enderecos", source = "enderecos")
    Usuario toEntity(UsuarioDTO dto);

    // Mapeia Entidade -> ResponseDTO
    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "nome", source = "entity.nome")
    @Mapping(target = "email", source = "entity.email")
    @Mapping(target = "login", source = "entity.login")
    @Mapping(target = "tipoUsuario", source = "entity.tipoUsuario")
    @Mapping(target = "enderecos", source = "entity.enderecos")
    UsuarioResponseDTO toResponseDto(Usuario entity);

    // Mapeia Entidade -> DTO (sem necessidade de anotações se for simples)
    UsuarioDTO toDto(Usuario entity);

    Endereco toEnderecoEntity(EnderecoDTO dto);

    EnderecoDTO toEnderecoDto(Endereco entity);

    List<Endereco> toEnderecoEntityList(List<EnderecoDTO> dtos);

    List<EnderecoDTO> toEnderecoDtoList(List<Endereco> entities);
}
