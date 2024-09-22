package com.github.naomisoubhia.ecommerce.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "vivx_topic", groupId = "vivx_group")
    public void consume(String message) {
        System.out.println("Mensagem recebida: " + message);
        
    }
}
