package org.natanxds.rabbitmqpractical.service;

import org.natanxds.rabbitmqpractical.controller.dto.OrderRequestDTO;
import org.natanxds.rabbitmqpractical.controller.dto.OrderResponseDTO;
import org.natanxds.rabbitmqpractical.model.Order;
import org.natanxds.rabbitmqpractical.repository.OrderRepository;
import org.natanxds.rabbitmqpractical.service.dto.OrderCreatedEvent;
import org.natanxds.rabbitmqpractical.util.Constants;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.natanxds.rabbitmqpractical.util.Constants.*;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final RabbitTemplate rabbitTemplate;

    public OrderService(OrderRepository orderRepository, RabbitTemplate rabbitTemplate) {
        this.orderRepository = orderRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public List<OrderResponseDTO> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(Order::toDTO)
                .toList();
    }

    public OrderResponseDTO save(OrderRequestDTO orderRequestDTO) {

        Order savedOrder = orderRepository.save(orderRequestDTO.toEntity());
        Message message = new Message(savedOrder.toOrderCreatedEvent().toString().getBytes());
        OrderCreatedEvent event = new OrderCreatedEvent(
                savedOrder.getProduct(),
                savedOrder.getQuantity(),
                savedOrder.getPrice().toString()
        );

        rabbitTemplate.convertAndSend(ORDER_CREATED_EXCHANGE, "", event);
        return savedOrder.toDTO();
    }
}
