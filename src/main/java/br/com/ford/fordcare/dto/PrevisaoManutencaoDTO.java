package br.com.ford.fordcare.dto;

public record PrevisaoManutencaoDTO(

        String modeloVeiculo,
        int quantidadeManutencoes,
        Double mediaCustos,
        Double previsaoProximaManutencao

) {
}