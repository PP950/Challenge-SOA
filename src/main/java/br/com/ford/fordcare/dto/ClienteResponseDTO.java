package br.com.ford.fordcare.dto;

public record ClienteResponseDTO(

        Long id,
        String nome,
        String email,
        String telefone,
        String cnh

) {
}