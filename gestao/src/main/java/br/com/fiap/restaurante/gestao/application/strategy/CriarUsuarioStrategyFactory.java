package br.com.fiap.restaurante.gestao.application.strategy;

import br.com.fiap.restaurante.gestao.domain.TipoUsuario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CriarUsuarioStrategyFactory {

    private final Map<TipoUsuario, CriarUsuarioStrategy> strategies;

    public CriarUsuarioStrategyFactory(
            @Qualifier("cliente") CriarUsuarioStrategy cliente,
            @Qualifier("proprietario") CriarUsuarioStrategy proprietario
    ) {
        this.strategies = Map.of(
                TipoUsuario.CLIENTE, cliente,
                TipoUsuario.PROPRIETARIO, proprietario
        );
    }

    public CriarUsuarioStrategy getStrategy(TipoUsuario tipoUsuario) {
        return strategies.get(tipoUsuario);
    }
}
