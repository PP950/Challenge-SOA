package br.com.ford.fordcare.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Especificacoes {

    @Min(value = 1900, message = "Ano inválido")
    private int ano;

    @NotNull
    private Double quilometragem;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipodeCombustivel tipodeCombustivel;


}
