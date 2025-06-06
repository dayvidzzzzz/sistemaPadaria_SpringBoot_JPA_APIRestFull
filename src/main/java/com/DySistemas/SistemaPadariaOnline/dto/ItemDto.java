package com.DySistemas.SistemaPadariaOnline.dto;

import jakarta.validation.constraints.NotBlank;

public record ItemDto(
        @NotBlank
        int qtd,

        @NotBlank
        long precoVenda) {
}
