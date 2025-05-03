package br.com.fiap.restaurante.gestao.application.usecase.impl;

import br.com.fiap.restaurante.gestao.domain.model.Endereco;
import br.com.fiap.restaurante.gestao.domain.model.Usuario;
import br.com.fiap.restaurante.gestao.domain.repository.UsuarioRepository;
import br.com.fiap.restaurante.gestao.exceptions.ResourceNotFoundException;
import br.com.fiap.restaurante.gestao.mapper.UsuarioMapper;
import br.com.fiap.restaurante.gestao.presentation.dto.EnderecoDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AtualizarUsuarioPorIdUseCase {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public AtualizarUsuarioPorIdUseCase(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Transactional
    public UsuarioResponseDTO executar(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setLogin(dto.getLogin());
        usuario.setSenha(dto.getSenha());
        usuario.setTipoUsuario(dto.getTipoUsuario());

        if (dto.getEnderecos() != null) {
            for (EnderecoDTO enderecoDTO : dto.getEnderecos()) {
                if (enderecoDTO.getId() != null) {
                    // Atualiza endereço existente
                    usuario.getEnderecos().stream()
                            .filter(e -> e.getId().equals(enderecoDTO.getId()))
                            .findFirst()
                            .ifPresent(e -> {
                                e.setRua(enderecoDTO.getRua());
                                e.setCidade(enderecoDTO.getCidade());
                                e.setEstado(enderecoDTO.getEstado());
                                e.setCep(enderecoDTO.getCep());
                                e.setPais(enderecoDTO.getPais());
                            });
                } else {
                    // Novo endereço
                    Endereco novoEndereco = usuarioMapper.toEnderecoEntity(enderecoDTO);
                    novoEndereco.setUsuario(usuario); // vínculo reverso
                    usuario.getEnderecos().add(novoEndereco);
                }
            }
        }

        return usuarioMapper.toResponseDto(usuarioRepository.save(usuario));
    }
}

