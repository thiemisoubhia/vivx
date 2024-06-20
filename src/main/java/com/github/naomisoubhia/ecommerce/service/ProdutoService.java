package com.github.naomisoubhia.ecommerce.service;

import com.github.naomisoubhia.ecommerce.model.Produtos;
import com.github.naomisoubhia.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produtos> list() {
        return produtoRepository.findAll();
    }

    public Produtos save(Produtos produto) {
        return produtoRepository.save(produto);
    }

    public Produtos findById(Long codigo_produto) {
        Optional<Produtos> produtoOptional = produtoRepository.findById(codigo_produto);
        return produtoOptional.orElse(null);
    }

    public void delete(Long codigo_produto) {
        produtoRepository.deleteById(codigo_produto);
    }
}
