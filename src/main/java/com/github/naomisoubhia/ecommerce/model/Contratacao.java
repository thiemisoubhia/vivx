package com.github.naomisoubhia.ecommerce.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRATACOES")
public class Contratacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMERO_CONTRATACAO")
    private Long numero_contratacao;
    
    @ManyToOne
    @JoinColumn(name = "CODIGO_CLIENTE", referencedColumnName = "CODIGO_CLIENTE")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "CODIGO_PRODUTO", referencedColumnName = "CODIGO_PRODUTO")
    private Produto produto;
    
    @Column(name = "DATA_CONTRATACAO")
    private LocalDate data_contratacao;

    public Long getNumero_contratacao() {
        return numero_contratacao;
    }

    public void setNumero_contratacao(Long numero_contratacao) {
        this.numero_contratacao = numero_contratacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(LocalDate data_contratacao) {
        this.data_contratacao = data_contratacao;
    }
}
