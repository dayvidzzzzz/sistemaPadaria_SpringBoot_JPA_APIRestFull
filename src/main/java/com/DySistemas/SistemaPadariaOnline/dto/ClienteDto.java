package com.DySistemas.SistemaPadariaOnline.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteDto(
        @NotBlank
        String nome,

        @NotBlank
        String endereco,

        @Email
        @NotBlank
        String email,

        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\.?\\d{2}")
        String cpf) {
}
