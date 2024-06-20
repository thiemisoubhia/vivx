package com.github.naomisoubhia.ecommerce.controller.dto.contratacao;

import java.util.Date;

public class ContratacaoRequestCreate {
    private Long codigo_cliente;
    private Long codigo_produto;
    private Date data_contratacao;

    // Getters and Setters
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

    public Date getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(Date data_contratacao) {
        this.data_contratacao = data_contratacao;
    }
}
