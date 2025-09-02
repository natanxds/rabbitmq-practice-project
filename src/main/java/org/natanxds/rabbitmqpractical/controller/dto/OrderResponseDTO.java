package org.natanxds.rabbitmqpractical.controller.dto;

import java.math.BigDecimal;

public record OrderResponseDTO(
        String product,
        Integer quantity,
        BigDecimal price
) {
}
