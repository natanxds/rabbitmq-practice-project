package org.natanxds.rabbitmqpractical.controller;

import org.natanxds.rabbitmqpractical.controller.dto.OrderRequestDTO;
import org.natanxds.rabbitmqpractical.controller.dto.OrderResponseDTO;
import org.natanxds.rabbitmqpractical.model.Order;
import org.natanxds.rabbitmqpractical.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<List<OrderResponseDTO>> findAll() {
        return ResponseEntity.ok(
                orderService.findAll()
        );
    }

    @PostMapping()
    public ResponseEntity<OrderResponseDTO> save(@RequestBody OrderRequestDTO orderRequestDTO) {
        return ResponseEntity.ok(
                orderService.save(orderRequestDTO)
        );
    }



}
