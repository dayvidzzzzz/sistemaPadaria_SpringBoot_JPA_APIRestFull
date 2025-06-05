package com.DySistemas.SistemaPadariaOnline.dto;

import com.DySistemas.SistemaPadariaOnline.model.enus.Cargo;
import jakarta.validation.constraints.*;

public record FuncionarioDto(
        @NotBlank
        String nome,

        @NotBlank
        String endereco,

        @Email
        @NotBlank
        String email,

        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\.?\\d{2}")
        String cpf,

        @NotNull
        Cargo cargo
) {}