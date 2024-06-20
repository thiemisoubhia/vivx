package com.github.naomisoubhia.ecommerce.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@Column(name = "cliente_id")
	private String clienteId;

	private String name;
	private String email;

	
	// Getters and setters

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
