package br.com.fiap.restaurante.gestao.presentation.controller;

import br.com.fiap.restaurante.gestao.application.usecase.impl.*;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioDTO;
import br.com.fiap.restaurante.gestao.presentation.dto.UsuarioResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final ListarUsuariosUseCase listarUsuariosUseCase;
    private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;
    private final AtualizarUsuarioPorIdUseCase atualizarUsuarioPorIdUseCase;
    private final ExcluirUsuarioPorIdUseCase excluirUsuarioPorIdUseCase;


    public UsuarioController(CriarUsuarioUseCase criarUsuarioUseCase, ListarUsuariosUseCase listarUsuariosUseCase, BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase, AtualizarUsuarioPorIdUseCase atualizarUsuarioPorIdUseCase, ExcluirUsuarioPorIdUseCase excluirUsuarioPorIdUseCase) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.listarUsuariosUseCase = listarUsuariosUseCase;
        this.buscarUsuarioPorIdUseCase = buscarUsuarioPorIdUseCase;
        this.atualizarUsuarioPorIdUseCase = atualizarUsuarioPorIdUseCase;
        this.excluirUsuarioPorIdUseCase = excluirUsuarioPorIdUseCase;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody UsuarioDTO usuarioDTO) {
        var response = criarUsuarioUseCase.executar(usuarioDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> listar(Pageable pageable) {
        var pagina = listarUsuariosUseCase.executar(pageable);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        var response = buscarUsuarioPorIdUseCase.executar(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        UsuarioResponseDTO response = atualizarUsuarioPorIdUseCase.executar(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        excluirUsuarioPorIdUseCase.executar(id);
        return ResponseEntity.noContent().build();
    }

}
