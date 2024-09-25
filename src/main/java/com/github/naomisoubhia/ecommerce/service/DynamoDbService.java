// package com.github.naomisoubhia.ecommerce.service;

// import com.github.naomisoubhia.ecommerce.model.Produto;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
// import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
// import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
// import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

// import java.util.HashMap;
// import java.util.Map;

// @Service
// public class DynamoDbService {

//     @Autowired
//     private DynamoDbClient dynamoDbClient;

//     // Nome da tabela no DynamoDB
//     private final String tableName = "Produtos";

//     public void saveProdutoToDynamoDB(Produto produto) {
//         Map<String, AttributeValue> item = new HashMap<>();
//         item.put("codigo_produto", AttributeValue.builder().n(String.valueOf(produto.getCodigo_produto())).build());
//         item.put("nome", AttributeValue.builder().s(produto.getNome()).build());
//         item.put("tipoProduto", AttributeValue.builder().s(produto.getTipoProduto()).build());
//         item.put("status", AttributeValue.builder().s(produto.getStatus()).build());
//         item.put("dataIn", AttributeValue.builder().s(produto.getDataIn()).build());
//         item.put("tipoAssinatura", AttributeValue.builder().s(produto.getTipoAssinatura()).build());
//         item.put("descricao", AttributeValue.builder().s(produto.getDescricao()).build());

//         PutItemRequest request = PutItemRequest.builder()
//                 .tableName(tableName)
//                 .item(item)
//                 .build();

//         dynamoDbClient.putItem(request);
//     }

//     public void deleteProdutoFromDynamoDB(Long codigo_produto) {
//         Map<String, AttributeValue> key = new HashMap<>();
//         key.put("codigo_produto", AttributeValue.builder().n(String.valueOf(codigo_produto)).build());

//         DeleteItemRequest request = DeleteItemRequest.builder()
//                 .tableName(tableName)
//                 .key(key)
//                 .build();

//         dynamoDbClient.deleteItem(request);
//     }
// }
