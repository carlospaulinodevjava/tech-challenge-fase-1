package br.com.fiap.restaurante.gestao.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoDTO {
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;
}
