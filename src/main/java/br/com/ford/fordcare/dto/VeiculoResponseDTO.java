package br.com.ford.fordcare.dto;

import br.com.ford.fordcare.entity.Especificacoes;

import java.time.LocalDate;

public record VeiculoResponseDTO(

        Long id,
        String modelo,
        LocalDate dataCompra,
        Especificacoes especificacoes,
        Long clienteId,
        String nomeCliente

) {
}