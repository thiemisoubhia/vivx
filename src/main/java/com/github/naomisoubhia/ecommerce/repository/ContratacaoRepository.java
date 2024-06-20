package com.github.naomisoubhia.ecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.checkpoint2.model.Contratacao;


@Repository
public interface ContratacaoRepository extends JpaRepository<Contratacao, Long>{

}
