package com.github.naomisoubhia.ecommerce.controller;

import com.github.naomisoubhia.ecommerce.controller.dto.produto.ProdutoRequestCreate;
import com.github.naomisoubhia.ecommerce.controller.dto.produto.ProdutoRequestUpdate;
import com.github.naomisoubhia.ecommerce.controller.dto.produto.ProdutoResponse;
import com.github.naomisoubhia.ecommerce.model.Produto;
import com.github.naomisoubhia.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoResponse> listAll() {
        return produtoService.list().stream()
                .map(ProdutoResponse::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{codigo_produto}")
    public ResponseEntity<ProdutoResponse> getById(@PathVariable Long codigo_produto) {
        Produtos produto = produtoService.findById(codigo_produto);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ProdutoResponse.toDto(produto));
    }

    @PostMapping
    public Produtos create(@RequestBody ProdutoRequestCreate dto) {
        Produtos produto = new Produtos();
        produto.setNome(dto.getNome());
        produto.setTipoProduto(dto.getTipoProduto());
        produto.setStatus(dto.getStatus());
        produto.setDataIn(dto.getDataIn());
        produto.setTipoAssinatura(dto.getTipoAssinatura());
        produto.setDescricao(dto.getDescricao());
        return produtoService.save(produto);
    }

    @PutMapping("/{codigo_produto}")
    public ResponseEntity<Produtos> update(@PathVariable Long codigo_produto, @RequestBody ProdutoRequestUpdate dto) {
        Produtos produto = produtoService.findById(codigo_produto);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        produto.setNome(dto.getNome());
        produto.setTipoProduto(dto.getTipoProduto());
        produto.setStatus(dto.getStatus());
        produto.setDataIn(dto.getDataIn());
        produto.setTipoAssinatura(dto.getTipoAssinatura());
        produto.setDescricao(dto.getDescricao());
        Produtos updatedProduto = produtoService.save(produto);
        return ResponseEntity.ok(updatedProduto);
    }

    @DeleteMapping("/{codigo_produto}")
    public void delete(@PathVariable Long codigo_produto) {
        produtoService.delete(codigo_produto);
    }
}
