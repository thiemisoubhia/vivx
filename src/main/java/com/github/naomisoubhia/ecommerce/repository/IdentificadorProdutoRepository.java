package com.github.naomisoubhia.ecommerce.repository;

import com.github.naomisoubhia.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IdentificadorProdutoRepository
extends JpaRepository<Product, Long> {

}
