package com.github.naomisoubhia.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.naomisoubhia.ecommerce.controller.dto.contratacao.ContratacaoRequestCreate;
import com.github.naomisoubhia.ecommerce.controller.dto.contratacao.ContratacaoRequestUpdate;
import com.github.naomisoubhia.ecommerce.controller.dto.contratacao.SearchedContratacao;
import com.github.naomisoubhia.ecommerce.model.Contratacao;
import com.github.naomisoubhia.ecommerce.repository.ContratacaoRepository;
import com.github.naomisoubhia.ecommerce.service.ContratacaoService;

@RestController
@RequestMapping(path = "/contratacao")
public class ContratacaoController {

    @Autowired
    private ContratacaoService contratacaoService;

    @Autowired
    private ContratacaoRepository contratacaoRepository;

    @GetMapping
    public List<SearchedContratacao> listAll() {
        List<SearchedContratacao> searchedContratacoes = contratacaoService.list().stream()
                .map(SearchedContratacao::toDto)
                .collect(Collectors.toList());
        return searchedContratacoes;
    }

    @GetMapping("/cliente/{codigo_cliente}")
    public List<SearchedContratacao> getByCodigoCliente(@PathVariable Long codigo_cliente) {
        List<SearchedContratacao> searchedContratacoes = contratacaoService.findByCodigoCliente(codigo_cliente).stream()
                .map(SearchedContratacao::toDto)
                .collect(Collectors.toList());
        return searchedContratacoes;
    }

    @GetMapping("/produto/{codigo_produto}")
    public List<SearchedContratacao> getByCodigoProduto(@PathVariable Long codigo_produto) {
        List<SearchedContratacao> searchedContratacoes = contratacaoService.findByCodigoProduto(codigo_produto).stream()
                .map(SearchedContratacao::toDto)
                .collect(Collectors.toList());
        return searchedContratacoes;
    }

    @PostMapping
    public Contratacao create(@RequestBody ContratacaoRequestCreate dto) {
        Contratacao contratacao = new Contratacao();
        contratacao.setCodigo_cliente(dto.getCodigo_cliente());
        contratacao.setCodigo_produto(dto.getCodigo_produto());
        contratacao.setData_contratacao(dto.getData_contratacao());
        return contratacaoService.save(contratacao);
    }

    @PutMapping
    public Contratacao update(@RequestBody ContratacaoRequestUpdate dto) {
        if (!contratacaoRepository.existsById(dto.getNumero_contratacao())) {
            throw new RuntimeException("Contratação não encontrada com ID: " + dto.getNumero_contratacao());
        }
        
        Contratacao contratacao = new Contratacao();
        contratacao.setNumero_contratacao(dto.getNumero_contratacao());
        contratacao.setCodigo_cliente(dto.getCodigo_cliente());
        contratacao.setCodigo_produto(dto.getCodigo_produto());
        contratacao.setData_contratacao(dto.getData_contratacao());
        return contratacaoService.save(contratacao);
    }

    @DeleteMapping("/{numero_contratacao}")
    public void delete(@PathVariable Long numero_contratacao) {
        contratacaoRepository.deleteById(numero_contratacao);
    }
}
