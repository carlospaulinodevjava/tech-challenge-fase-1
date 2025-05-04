package br.com.fiap.restaurante.gestao.application.usecase.impl;

import br.com.fiap.restaurante.gestao.domain.model.Usuario;
import br.com.fiap.restaurante.gestao.domain.repository.UsuarioRepository;
import br.com.fiap.restaurante.gestao.presentation.dto.LoginRequestDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.LoginResponseDTO;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AutenticarUsuarioUseCase(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDTO autenticar(LoginRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByLogin(dto.login())
                .orElseThrow(() -> new UsernameNotFoundException("Login inválido"));

        if (!passwordEncoder.matches(dto.senha(), usuario.getSenha())) {
            throw new BadCredentialsException("Senha inválida");
        }

        return new LoginResponseDTO(usuario.getNome(), usuario.getEmail(), usuario.getTipoUsuario().name());
    }
}
