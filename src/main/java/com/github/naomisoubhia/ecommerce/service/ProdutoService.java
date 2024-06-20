package com.github.naomisoubhia.ecommerce.service;

import com.github.naomisoubhia.ecommerce.model.Produto;
import com.github.naomisoubhia.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(String id) {
        return produtoRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("Produto not found"));
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void delete(String id) {
        produtoRepository.deleteById(Long.valueOf(id));
    }
}
