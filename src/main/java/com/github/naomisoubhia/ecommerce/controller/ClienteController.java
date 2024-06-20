package com.github.naomisoubhia.ecommerce.controller;

import com.github.naomisoubhia.ecommerce.controller.dto.produtos.ProdutoRequestCreate;
import com.github.naomisoubhia.ecommerce.controller.dto.produtos.ProdutoRequestUpdate;
import com.github.naomisoubhia.ecommerce.controller.dto.produtos.ProdutoResponse;
import com.github.naomisoubhia.ecommerce.model.Produto;
import com.github.naomisoubhia.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ProdutoResponse getById(@PathVariable Long codigo_produto) {
        Produto produto = produtoService.findById(codigo_produto);
        if (produto == null) {
            throw new RuntimeException("Produto não encontrado com o código: " + codigo_produto);
        }
        return ProdutoResponse.toDto(produto);
    }

    @PostMapping
    public Produto create(@RequestBody ProdutoRequestCreate dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setTipoProduto(dto.getTipoProduto());
        produto.setStatus(dto.getStatus());
        produto.setDataIn(dto.getDataIn());
        produto.setTipoAssinatura(dto.getTipoAssinatura());
        produto.setDescricao(dto.getDescricao());
        return produtoService.save(produto);
    }

    @PutMapping("/{codigo_produto}")
    public Produto update(@PathVariable Long codigo_produto, @RequestBody ProdutoRequestUpdate dto) {
        Produto produto = produtoService.findById(codigo_produto);
        if (produto == null) {
            throw new RuntimeException("Produto não encontrado com o código: " + codigo_produto);
        }
        produto.setNome(dto.getNome());
        produto.setTipoProduto(dto.getTipoProduto());
        produto.setStatus(dto.getStatus());
        produto.setDataIn(dto.getDataIn());
        produto.setTipoAssinatura(dto.getTipoAssinatura());
        produto.setDescricao(dto.getDescricao());
        return produtoService.save(produto);
    }

    @DeleteMapping("/{codigo_produto}")
    public void delete(@PathVariable Long codigo_produto) {
        produtoService.delete(codigo_produto);
    }
}
