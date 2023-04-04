package br.com.ada.gerenciadorEolico.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioLogin(
        @NotBlank String login, @NotBlank String senha) {
}
