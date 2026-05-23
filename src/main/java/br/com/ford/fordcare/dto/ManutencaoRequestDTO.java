package br.com.ford.fordcare.dto;

import java.time.LocalDate;

public record ManutencaoRequestDTO(

        String descricao,
        LocalDate data,
        Double quilometragem,
        Double custo,
        Long veiculoId

) {
}