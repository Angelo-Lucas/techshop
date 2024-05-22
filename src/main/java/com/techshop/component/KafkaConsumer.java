package com.techshop.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techshop.domain.Order;
import com.techshop.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class KafkaConsumer {

    @Autowired
    private OrderRepository orderRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${topic}", groupId = "group_id")
    public void consume(String message) {
        try {
            log.info("Consumindo mensagem: {}", message);
            Order order = objectMapper.readValue(message, Order.class);
            orderRepository.save(order);
            log.info("Mensagem salva no banco de dados: {}", order);
        } catch (IOException e) {
            log.error("Erro ao processar mensagem: {}", e.getMessage(), e);
        }
    }
}
