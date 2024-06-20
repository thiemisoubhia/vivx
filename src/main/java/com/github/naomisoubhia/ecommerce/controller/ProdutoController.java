package com.github.naomisoubhia.ecommerce.controller;

import com.github.naomisoubhia.ecommerce.model.Produtos;
import com.github.naomisoubhia.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produtos> listAll() {
        return produtoService.list();
    }

    @GetMapping("/{codigo_produto}")
    public ResponseEntity<Produtos> getById(@PathVariable Long codigo_produto) {
        Produtos produto = produtoService.findById(codigo_produto);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public Produtos create(@RequestBody Produtos produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{codigo_produto}")
    public ResponseEntity<Produtos> update(@PathVariable Long codigo_produto, @RequestBody Produtos produtoDetails) {
        Produtos produto = produtoService.findById(codigo_produto);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        produto.setNome(produtoDetails.getNome());
        produto.setTipoProduto(produtoDetails.getTipoProduto());
        produto.setStatus(produtoDetails.getStatus());
        produto.setDataIn(produtoDetails.getDataIn());
        produto.setTipoAssinatura(produtoDetails.getTipoAssinatura());
        produto.setDescricao(produtoDetails.getDescricao());
        Produtos updatedProduto = produtoService.save(produto);
        return ResponseEntity.ok(updatedProduto);
    }

    @DeleteMapping("/{codigo_produto}")
    public void delete(@PathVariable Long codigo_produto) {
        produtoService.delete(codigo_produto);
    }
}
