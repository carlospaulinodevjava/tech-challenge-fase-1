package br.com.fiap.restaurante.gestao.domain.repository;

import br.com.fiap.restaurante.gestao.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
