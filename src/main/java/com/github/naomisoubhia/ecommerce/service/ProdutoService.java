package com.github.naomisoubhia.ecommerce.service;

import com.github.naomisoubhia.ecommerce.model.Produto;
import com.github.naomisoubhia.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private DynamoDbService dynamoDbService;

    public List<Produto> list() {
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto) {
        // Salva no banco de dados Oracle
        Produto savedProduto = produtoRepository.save(produto);
        
        // Tenta salvar no DynamoDB
        try {
            dynamoDbService.saveProdutoToDynamoDB(savedProduto);
        } catch (DynamoDbException e) {
            // Lida com exceções do DynamoDB (logar ou tratar conforme necessário)
            System.err.println("Erro ao salvar no DynamoDB: " + e.getMessage());
        }

        return savedProduto;
    }

    public Produto findById(Long codigo_produto) {
        Optional<Produto> produtoOptional = produtoRepository.findById(codigo_produto);
        return produtoOptional.orElse(null);
    }

    public void delete(Long codigo_produto) {
        // Remove do banco de dados Oracle
        produtoRepository.deleteById(codigo_produto);

        // Tenta remover no DynamoDB
        try {
            dynamoDbService.deleteProdutoFromDynamoDB(codigo_produto);
        } catch (DynamoDbException e) {
            // Lida com exceções do DynamoDB
            System.err.println("Erro ao deletar no DynamoDB: " + e.getMessage());
        }
    }
}
