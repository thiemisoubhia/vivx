package com.github.naomisoubhia.ecommerce.controller;

import com.github.naomisoubhia.ecommerce.controller.dto.contratacao.ContratacaoRequestCreate;
import com.github.naomisoubhia.ecommerce.controller.dto.contratacao.ContratacaoRequestUpdate;
import com.github.naomisoubhia.ecommerce.controller.dto.contratacao.SearchedContratacao;
import com.github.naomisoubhia.ecommerce.model.Contratacao;
import com.github.naomisoubhia.ecommerce.service.ContratacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/contratacao")
public class ContratacaoController {

    @Autowired
    private ContratacaoService contratacaoService;

    @GetMapping
    public List<SearchedContratacao> listAll() {
        return contratacaoService.list().stream().map(SearchedContratacao::toDto)
                .collect(Collectors.toList());
    }

@PostMapping
public Contratacao create(@RequestBody ContratacaoRequestCreate dto) {
    Contratacao contratacao = new Contratacao();
    // Certifique-se de que os métodos do DTO correspondem aos atributos corretos
    contratacao.setCodigo_cliente(dto.getCodigo_cliente());
    contratacao.setCodigo_produto(dto.getCodigo_produto());
    contratacao.setData_contratacao(dto.getData_contratacao());

    Contratacao result = contratacaoService.save(contratacao);
    return result;
}


    @PutMapping("/{numero_contratacao}")
    public ResponseEntity<Contratacao> update(@PathVariable Long numero_contratacao, @RequestBody ContratacaoRequestUpdate dto) {
        Contratacao contratacao = contratacaoService.findById(numero_contratacao);
        if (contratacao == null) {
            return ResponseEntity.notFound().build();
        }

        contratacao.setCodigo_cliente(dto.getCodigo_cliente());
        contratacao.setCodigo_produto(dto.getCodigo_produto());
        contratacao.setData_contratacao(dto.getData_contratacao());

        Contratacao updatedContratacao = contratacaoService.save(contratacao);
        return ResponseEntity.ok(updatedContratacao);
    }

    @DeleteMapping("/{numero_contratacao}")
    public void delete(@PathVariable Long numero_contratacao) {
        contratacaoService.delete(numero_contratacao);
    }

    @GetMapping("/cliente/{codigo_cliente}")
    public List<SearchedContratacao> findByCodigoCliente(@PathVariable Long codigo_cliente) {
        return contratacaoService.findByCodigoCliente(codigo_cliente).stream()
                .map(SearchedContratacao::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/produto/{codigo_produto}")
    public List<SearchedContratacao> findByCodigoProduto(@PathVariable Long codigo_produto) {
        return contratacaoService.findByCodigoProduto(codigo_produto).stream()
                .map(SearchedContratacao::toDto)
                .collect(Collectors.toList());
    }
}
