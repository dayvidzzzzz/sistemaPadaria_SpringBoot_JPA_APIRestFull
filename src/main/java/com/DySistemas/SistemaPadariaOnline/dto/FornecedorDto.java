package com.DySistemas.SistemaPadariaOnline.dto;

import jakarta.validation.constraints.NotBlank;

public record FornecedorDto(
        @NotBlank
        String CPNJ,

        @NotBlank
        String rasaoSocial,

        @NotBlank
        String endereco,

        @NotBlank
        String telefone) {
}
