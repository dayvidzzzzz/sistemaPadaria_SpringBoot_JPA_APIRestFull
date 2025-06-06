package com.DySistemas.SistemaPadariaOnline.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record EncomendaDto(
        @DateTimeFormat
        LocalDate data,

        @NotBlank
        long valorTotal,

        @NotBlank
        int idCliente,

        @NotBlank
        int idFuncionario,

        @NotBlank
        int idPedido) {
}
