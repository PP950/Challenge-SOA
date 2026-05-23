package br.com.ford.fordcare.dto;

import java.time.LocalDate;

public record ManutencaoResponseDTO(

        Long manuntecaoId,
        String descricao,
        LocalDate data,
        Double quilometragem,
        Double custo,
        Long veiculoId,
        String modeloVeiculo

) {
}