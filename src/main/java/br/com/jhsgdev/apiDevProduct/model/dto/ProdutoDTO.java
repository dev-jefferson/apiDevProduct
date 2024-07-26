package br.com.jhsgdev.apiDevProduct.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ProdutoDTO(
    Long id,
    @NotBlank String nome,
    @NotBlank String reponsavel,
    LocalDateTime data_criacao,
    LocalDateTime data_modificacao,
    @NotBlank String categoria) {
}
