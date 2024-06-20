package com.github.naomisoubhia.ecommerce.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contratacoes")
public class Contratacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numero_contratacao;
	
	private Long codigo_cliente;
	private Long codigo_produto;
	private LocalDate data_contratacao;

	//get e set
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
	
	public LocalDate getData_contratacao() {
		return data_contratacao;
	}
	public void setData_contratacao(LocalDate data_contratacao) {
		this.data_contratacao = data_contratacao;
	}
	
}
