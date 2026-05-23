package br.com.ford.fordcare.dto;

import br.com.ford.fordcare.entity.Especificacoes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record VeiculoRequestDTO(
        @NotBlank
        String modelo,
        @NotNull
        LocalDate dataCompra,
        @Valid
        @NotNull
        Especificacoes especificacoes,

        Long clienteId
) {
}
