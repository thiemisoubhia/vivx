package com.github.naomisoubhia.ecommerce.controller.dto;

import java.util.List;

public class ClientDTO {
    private String clientId;
    private String name;
    private String email;
    private List<ProductDTO> products;

    public ClientDTO() {}

    // Getters e setters
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
