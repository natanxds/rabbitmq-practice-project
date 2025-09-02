package org.natanxds.rabbitmqpractical.controller.dto;

import org.natanxds.rabbitmqpractical.model.Order;

import java.math.BigDecimal;

public record OrderRequestDTO (
        String product,
        Integer quantity,
        BigDecimal price
){

    public Order toEntity() {
        Order order = new Order();
        order.setProduct(this.product);
        order.setQuantity(this.quantity);
        order.setPrice(this.price);
        return order;
    }
}
