package com.github.naomisoubhia.ecommerce.service;

import com.github.naomisoubhia.ecommerce.model.Contratacao;
import com.github.naomisoubhia.ecommerce.repository.ContratacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class ContratacaoService {

    @Autowired
    private ContratacaoRepository contratacaoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Contratacao> list() {
        return contratacaoRepository.findAll();
    }

    public Contratacao findById(Long id) {
        return contratacaoRepository.findById(id).orElse(null);
    }

    public List<Contratacao> findByCodigoCliente(Long codigoCliente) {
        Query query = entityManager.createQuery("SELECT c FROM Contratacao c WHERE c.codigo_cliente = :codigoCliente");
        query.setParameter("codigoCliente", codigoCliente);
        return query.getResultList();
    }

    public List<Contratacao> findByCodigoProduto(Long codigoProduto) {
        Query query = entityManager.createQuery("SELECT c FROM Contratacao c WHERE c.codigo_produto = :codigoProduto");
        query.setParameter("codigoProduto", codigoProduto);
        return query.getResultList();
    }

    public Contratacao save(Contratacao contratacao) {
        return contratacaoRepository.save(contratacao);
    }

    public void delete(Long id) {
        contratacaoRepository.deleteById(id);
    }
}
