package com.github.naomisoubhia.ecommerce.controller.dto;

import java.util.List;

public class ClienteDTO {
    private String clienteId;
    private String name;
    private String email;

    public ClienteDTO() {}

    // Getters e setters
    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
