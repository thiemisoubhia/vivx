package com.github.naomisoubhia.ecommerce.repository;

import com.github.naomisoubhia.ecommerce.model.Contratacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratacaoRepository extends JpaRepository<Contratacao, Long> {

    List<Contratacao> findByCodigoCliente(Long codigoCliente);

    List<Contratacao> findByCodigoProduto(Long codigoProduto);
}
