package br.com.fiap.restaurante.gestao.application.usecase.impl;

import br.com.fiap.restaurante.gestao.domain.repository.UsuarioRepository;
import br.com.fiap.restaurante.gestao.exceptions.ResourceNotFoundException;
import br.com.fiap.restaurante.gestao.mapper.UsuarioMapper;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioPorIdUseCase {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public BuscarUsuarioPorIdUseCase(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioResponseDTO executar(Long id){
        return usuarioRepository.findById(id).map(usuarioMapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
    }

}
