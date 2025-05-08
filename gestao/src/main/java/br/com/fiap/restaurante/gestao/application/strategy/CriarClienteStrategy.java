package br.com.fiap.restaurante.gestao.application.strategy;

import br.com.fiap.restaurante.gestao.domain.TipoUsuario;
import br.com.fiap.restaurante.gestao.domain.model.Usuario;
import br.com.fiap.restaurante.gestao.domain.repository.UsuarioRepository;
import br.com.fiap.restaurante.gestao.mapper.UsuarioMapper;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Qualifier("cliente")
public class CriarClienteStrategy implements CriarUsuarioStrategy{

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PasswordEncoder encoder;

    public CriarClienteStrategy(UsuarioRepository repository, UsuarioMapper mapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }


    @Override
    public UsuarioResponseDTO criar(UsuarioDTO dto) {
        dto.setSenha(encoder.encode(dto.getSenha()));
        Usuario usuario = mapper.toEntity(dto);
        usuario.setTipoUsuario(TipoUsuario.CLIENTE);
        usuario.setDataUltimaAlteracao(LocalDateTime.now());
        usuario.getEnderecos().forEach(e -> e.setUsuario(usuario));
        return mapper.toResponseDto(repository.save(usuario));
    }


}
