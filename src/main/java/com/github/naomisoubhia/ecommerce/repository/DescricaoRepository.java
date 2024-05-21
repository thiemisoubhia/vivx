package com.github.naomisoubhia.ecommerce.repository;

import com.github.naomisoubhia.ecommerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescricaoRepository
	extends JpaRepository<Client, Long> {

}
