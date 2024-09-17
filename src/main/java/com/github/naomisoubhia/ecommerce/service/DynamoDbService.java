package com.github.naomisoubhia.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class DynamoDbService {

    @Autowired
    private DynamoDbClient dynamoDbClient;

    public void saveProdutoToDynamoDB(Produto produto) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("codigo_produto", AttributeValue.builder().n(String.valueOf(produto.getCodigo_produto())).build());
        item.put("nome", AttributeValue.builder().s(produto.getNome()).build());
        item.put("tipoProduto", AttributeValue.builder().s(produto.getTipoProduto()).build());
        item.put("status", AttributeValue.builder().s(produto.getStatus()).build());
        item.put("dataIn", AttributeValue.builder().s(produto.getDataIn()).build());
        item.put("tipoAssinatura", AttributeValue.builder().s(produto.getTipoAssinatura()).build());
        item.put("descricao", AttributeValue.builder().s(produto.getDescricao()).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName("Produtos")  // Nome da tabela no DynamoDB
                .item(item)
                .build();

        dynamoDbClient.putItem(request);
    }
}
