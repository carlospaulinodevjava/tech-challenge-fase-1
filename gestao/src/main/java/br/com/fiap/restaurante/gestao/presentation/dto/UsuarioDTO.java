package br.com.fiap.restaurante.gestao.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private String nome;
    private String email;
    private String login;
    private String senha;
    private List<EnderecoDTO> enderecos;
}
