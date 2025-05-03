package br.com.fiap.restaurante.gestao.presentation.dto;

import java.util.List;

public record ValidationErrorDTO(List<String> errors, int status) {
}
