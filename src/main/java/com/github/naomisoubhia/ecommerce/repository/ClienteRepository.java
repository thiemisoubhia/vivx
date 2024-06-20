package com.github.naomisoubhia.ecommerce.repository;

import com.github.naomisoubhia.ecommerce.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository
	extends JpaRepository<Cliente, Long> {

}
