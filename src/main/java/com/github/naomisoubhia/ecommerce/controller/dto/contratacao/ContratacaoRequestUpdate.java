package com.github.naomisoubhia.ecommerce.controller.dto.contratacao;

import java.time.LocalDate;

public class ContratacaoRequestUpdate {
    private Long numero_contratacao, codigo_cliente;
    private LocalDate data_contratacao;
    
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
    public LocalDate getData_contratacao() {
        return data_contratacao;
    }
    public void setData_contratacao(LocalDate data_contratacao) {
        this.data_contratacao = data_contratacao;
    }
    
}

