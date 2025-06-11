package com.DySistemas.SistemaPadariaOnline.dto;

import jakarta.validation.constraints.NotBlank;

public record ProdutoDto(
        @NotBlank
        long precoCompra,

        @NotBlank
        String descricao,

        @NotBlank
        int idFornecedor) {
}
