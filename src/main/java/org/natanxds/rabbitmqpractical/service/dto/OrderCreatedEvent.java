package org.natanxds.rabbitmqpractical.service.dto;

import lombok.AllArgsConstructor;


public record OrderCreatedEvent(
        String product,
        Integer quantity,
        String price
) {
}
