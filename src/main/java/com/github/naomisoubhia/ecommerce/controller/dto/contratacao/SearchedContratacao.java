package com.github.naomisoubhia.ecommerce.controller.dto.contratacao;

import com.github.naomisoubhia.ecommerce.model.Contratacao;


public class SearchedContratacao {
    private Long numero_contratacao, codigo_cliente, codigo_produto;

    public Long getNumero_contratacao() {
        return numero_contratacao;
    }

    public void setNumero_contratacao(Long numero_contratacao) {
        this.numero_contratacao = numero_contratacao;
    }

    public Long getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(Long codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public Long getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(Long codigo_produto) {
        this.codigo_produto = codigo_produto;
    }
    
    public static SearchedContratacao toDto(Contratacao contratacao){
        SearchedContratacao dto = new SearchedContratacao();
        dto.setNumero_contratacao(contratacao.getNumero_contratacao());
        dto.setCodigo_cliente(contratacao.getCodigo_cliente());
        dto.setCodigo_produto(contratacao.getCodigo_produto());
        return dto;
    }
}
