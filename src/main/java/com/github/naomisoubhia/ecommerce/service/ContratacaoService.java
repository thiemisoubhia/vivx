package com.github.naomisoubhia.ecommerce.service;

import com.github.naomisoubhia.ecommerce.model.Contratacao;
import com.github.naomisoubhia.ecommerce.repository.ContratacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratacaoService {

    @Autowired
    private ContratacaoRepository contratacaoRepository;

    public List<Contratacao> list() {
        return contratacaoRepository.findAll();
    }

    public Contratacao findById(Long id) {
        return contratacaoRepository.findById(id).orElse(null);
    }

    public List<Contratacao> findByCodigoCliente(Long codigoCliente) {
        return contratacaoRepository.findByCodigoCliente(codigoCliente);
    }

    public List<Contratacao> findByCodigoProduto(Long codigoProduto) {
        return contratacaoRepository.findByCodigoProduto(codigoProduto);
    }

    public Contratacao save(Contratacao contratacao) {
        return contratacaoRepository.save(contratacao);
    }

    public void delete(Long id) {
        contratacaoRepository.deleteById(id);
    }
}
