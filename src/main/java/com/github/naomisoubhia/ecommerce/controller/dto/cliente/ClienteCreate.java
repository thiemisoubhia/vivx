package com.github.naomisoubhia.ecommerce.controller.dto.cliente;

public class ClienteCreate {
    private String nome;
    private String email;
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
