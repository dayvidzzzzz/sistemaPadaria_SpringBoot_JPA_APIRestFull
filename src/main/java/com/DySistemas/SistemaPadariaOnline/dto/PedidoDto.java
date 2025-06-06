package com.DySistemas.SistemaPadariaOnline.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record PedidoDto(
        @NotBlank
        LocalDate data,

        @NotBlank
        long valorPedido,

        @NotBlank
        int idEncomenda,

        @NotBlank
        List<Integer> idItens) {
}
