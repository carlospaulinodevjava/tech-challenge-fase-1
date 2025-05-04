package br.com.fiap.restaurante.gestao.exceptions;

public class SenhaIncorretaException extends RuntimeException {
    public SenhaIncorretaException(String message) {
        super(message);
    }
}
