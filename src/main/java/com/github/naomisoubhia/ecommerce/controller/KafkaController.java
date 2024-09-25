package com.github.naomisoubhia.ecommerce.controller;

import com.github.naomisoubhia.ecommerce.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaTestController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/kafka/send")
    public String sendMessageToKafka(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return "Mensagem enviada ao Kafka: " + message;
    }
}
