package br.com.fiap.restaurante.gestao.application.usecase.impl;

import br.com.fiap.restaurante.gestao.domain.model.Usuario;
import br.com.fiap.restaurante.gestao.domain.repository.UsuarioRepository;
import br.com.fiap.restaurante.gestao.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExcluirUsuarioPorIdUseCase {

    private final UsuarioRepository usuarioRepository;

    public ExcluirUsuarioPorIdUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void executar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com id: " + id));

        usuarioRepository.delete(usuario);
    }
}
