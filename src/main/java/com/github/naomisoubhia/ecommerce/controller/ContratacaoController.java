package com.github.naomisoubhia.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint2.controller.dto.contratacao.ContratacaoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.contratacao.ContratacaoRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.contratacao.SearchedContratacao;
import br.com.fiap.checkpoint2.model.Contratacao;
import br.com.fiap.checkpoint2.repository.ContratacaoRepository;
import br.com.fiap.checkpoint2.service.ContratacaoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "/contratacao")
public class ContratacaoController {

	@Autowired
	private ContratacaoService contratacaoService;

	@Autowired
	private ContratacaoRepository contratacaoRepository;

	@GetMapping
	public List<SearchedContratacao> listall() {
		List<SearchedContratacao> searchedPessoa = contratacaoService.list().stream().map(SearchedContratacao::toDto)
				.collect(Collectors.toList());
		return searchedPessoa;
	}

	@PostMapping
	public Contratacao create(@RequestBody ContratacaoRequestCreate dto) {
		Contratacao contratacao = new Contratacao();
		contratacao.setCodigo_cliente(dto.getCodigo_cliente());
		contratacao.setData_contratacao(dto.getData_contratacao());
		Contratacao result = contratacaoService.save(contratacao);
		return result;
	}

	@PutMapping
	public Contratacao update(@RequestBody ContratacaoRequestUpdate dto) {
		
		boolean exists =
				contratacaoRepository.existsById(dto.getNumero_contratacao());
		
		if (!exists) {
			throw new RuntimeException("Id nÃ£o encontrado " 
							+ dto.getNumero_contratacao());			
		}
		
		Contratacao contratacao = new Contratacao();
		contratacao.setCodigo_cliente(dto.getCodigo_cliente());
		contratacao.setData_contratacao(dto.getData_contratacao());
		contratacao.setNumero_contratacao(dto.getNumero_contratacao());
		Contratacao result = contratacaoService.save(contratacao);
		return result;
	}

	@DeleteMapping(value = "{numero_contratacao}")
	public void delete(@PathVariable Long numero_contratacao) {
		contratacaoRepository.deleteById(numero_contratacao);
	}

}
