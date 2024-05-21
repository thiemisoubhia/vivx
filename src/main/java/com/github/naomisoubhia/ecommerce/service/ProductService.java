package com.github.naomisoubhia.ecommerce.service;

import com.github.naomisoubhia.ecommerce.model.Product;
import com.github.naomisoubhia.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProdutoRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(String id) {
        productRepository.deleteById(Long.valueOf(id));
    }
}
