package com.github.naomisoubhia.ecommerce.controller.dto.produtos;

import com.github.naomisoubhia.ecommerce.model.Produto;

public class ProdutoResponse {
    private Long codigoProduto;
    private String nome;

    // Getters and Setters
    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static ProdutoResponse toDto(Produto produto) {
        ProdutoResponse dto = new ProdutoResponse();
        dto.setCodigoProduto(produto.getCodigoProduto());
        dto.setNome(produto.getNome());
        return dto;
    }
}
