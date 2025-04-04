package br.fiap.api_security.dto;

import br.fiap.api_security.entity.UserRole;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank String login,
        @NotBlank String senha,
        @NotBlank UserRole role
        ) {
}
