// package com.github.naomisoubhia.ecommerce.config;

// import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
// import software.amazon.awssdk.regions.Region;
// import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class DynamoDbConfig {

//     @Bean
//     public DynamoDbClient dynamoDbClient() {
//         return DynamoDbClient.builder()
//                 .region(Region.US_EAST_1)  // Altere para sua região
//                 .credentialsProvider(ProfileCredentialsProvider.create())
//                 .build();
//     }
// }
