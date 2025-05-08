package br.com.fiap.restaurante.gestao.application.usecase.impl;

import br.com.fiap.restaurante.gestao.application.strategy.CriarUsuarioStrategyFactory;
import br.com.fiap.restaurante.gestao.domain.model.Usuario;
import br.com.fiap.restaurante.gestao.domain.repository.UsuarioRepository;
import br.com.fiap.restaurante.gestao.mapper.UsuarioMapper;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioResponseDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CriarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    private final CriarUsuarioStrategyFactory strategyFactory;

    public CriarUsuarioUseCase(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder, CriarUsuarioStrategyFactory strategyFactory) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
        this.strategyFactory = strategyFactory;
    }

    public UsuarioResponseDTO executar(UsuarioDTO dto) {
        var strategy = strategyFactory.getStrategy(dto.getTipoUsuario());
        return strategy.criar(dto);
    }
}
