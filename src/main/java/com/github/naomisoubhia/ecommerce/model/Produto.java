package com.github.naomisoubhia.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTOS")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_PRODUTO")
    private Long codigo_produto;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TIPO_PRODUTO")
    private String tipoProduto;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DATA_IN")
    private String dataIn;

    @Column(name = "TIPO_ASSINATURA")
    private String tipoAssinatura;

    @Column(name = "DESCRICAO")
    private String descricao;

    public Long getCodigo_produto() {
        return codigo_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataIn() {
        return dataIn;
    }

    public void setDataIn(String dataIn) {
        this.dataIn = dataIn;
    }

    public String getTipoAssinatura() {
        return tipoAssinatura;
    }

    public void setTipoAssinatura(String tipoAssinatura) {
        this.tipoAssinatura = tipoAssinatura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
