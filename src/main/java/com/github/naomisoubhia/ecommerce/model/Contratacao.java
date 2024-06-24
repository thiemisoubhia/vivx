package com.github.naomisoubhia.ecommerce.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contratacoes")
public class Contratacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contratacao_seq")
    @SequenceGenerator(name = "contratacao_seq", sequenceName = "contratacao_seq", allocationSize = 1)
    private Long numero_contratacao;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "codigo_produto")
    private Produto produto;

    private LocalDate data_contratacao;

    // Getters e Setters
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
