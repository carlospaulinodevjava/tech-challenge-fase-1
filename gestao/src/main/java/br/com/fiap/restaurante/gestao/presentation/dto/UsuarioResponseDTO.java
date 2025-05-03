package br.com.fiap.restaurante.gestao.presentation.dto;


import br.com.fiap.restaurante.gestao.domain.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String login;
    private TipoUsuario tipoUsuario;
    private LocalDateTime dataUltimaAlteracao;
    private List<EnderecoDTO> enderecos;

}
