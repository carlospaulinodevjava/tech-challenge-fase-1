package br.com.fiap.restaurante.gestao.presentation.dto;



import br.com.fiap.restaurante.gestao.domain.TipoUsuario;
import br.com.fiap.restaurante.gestao.domain.model.Endereco;
import jakarta.persistence.*;
import lombok.*;

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
    private String senha;
    private TipoUsuario tipoUsuario;
    private LocalDateTime dataUltimaAlteracao;
    private List<EnderecoDTO> enderecos;

}
