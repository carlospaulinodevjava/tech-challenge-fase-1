package br.com.fiap.restaurante.gestao.application.usecase.impl;

import br.com.fiap.restaurante.gestao.domain.repository.UsuarioRepository;
import br.com.fiap.restaurante.gestao.exceptions.ResourceNotFoundException;
import br.com.fiap.restaurante.gestao.mapper.UsuarioMapper;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscarUsuarioPorIdUseCase {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public Optional<UsuarioResponseDTO> executar(Long id){
        return Optional.ofNullable(usuarioRepository.findById(id).map(usuarioMapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado")));
    }

}
