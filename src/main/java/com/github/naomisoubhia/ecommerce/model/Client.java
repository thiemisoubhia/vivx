package com.github.naomisoubhia.ecommerce.model;

import com.github.naomisoubhia.ecommerce.model.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
	@Id
	@Column(name = "client_id")
	private String clientId;

	private String name;
	private String email;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products;

	// Getters and setters

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
