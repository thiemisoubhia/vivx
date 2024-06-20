package com.github.naomisoubhia.ecommerce.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.model.Contratacao;
import br.com.fiap.checkpoint2.repository.ContratacaoRepository;


@Service
public class ContratacaoService {

    @Autowired
    private ContratacaoRepository contratacaoRepository;

    public List<Contratacao> list() {
        return contratacaoRepository.findAll();
    }

    public Contratacao save(Contratacao c) {
        return contratacaoRepository.save(c);
    }

}
