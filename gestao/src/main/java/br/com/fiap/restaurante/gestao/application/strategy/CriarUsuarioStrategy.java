package br.com.fiap.restaurante.gestao.application.strategy;

import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioResponseDTO;

public interface CriarUsuarioStrategy {
    UsuarioResponseDTO criar(UsuarioDTO dto);
}
