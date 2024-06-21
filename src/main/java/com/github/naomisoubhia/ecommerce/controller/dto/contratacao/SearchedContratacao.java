package com.github.naomisoubhia.ecommerce.controller.dto.contratacao;

import com.github.naomisoubhia.ecommerce.model.Contratacao;

import java.time.LocalDate;

public class SearchedContratacao {
    private Long numeroContratacao;
    private Long codigoCliente;
    private Long codigoProduto;
    private LocalDate dataContratacao;

    // Getters and Setters

    public static SearchedContratacao toDto(Contratacao contratacao) {
        SearchedContratacao dto = new SearchedContratacao();
        dto.setNumeroContratacao(contratacao.getNumero_contratacao());
        dto.setCodigoCliente(contratacao.getCliente().getCodigo_cliente());
        dto.setCodigoProduto(contratacao.getProduto().getCodigo_produto());
        dto.setDataContratacao(contratacao.getData_contratacao());
        return dto;
    }

    // Getters and Setters

    public Long getNumeroContratacao() {
        return numeroContratacao;
    }

    public void setNumeroContratacao(Long numeroContratacao) {
        this.numeroContratacao = numeroContratacao;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}
