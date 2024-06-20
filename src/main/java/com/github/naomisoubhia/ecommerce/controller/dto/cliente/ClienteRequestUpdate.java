package com.github.naomisoubhia.ecommerce.controller.dto.cliente;

public class ClienteRequestUpdate {
    private Long codigo_cliente;
    private String nome;
    private String email;

    // Getters e Setters
    public Long getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(Long codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
