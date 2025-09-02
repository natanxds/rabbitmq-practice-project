package org.natanxds.rabbitmqpractical.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.natanxds.rabbitmqpractical.controller.dto.OrderResponseDTO;
import org.natanxds.rabbitmqpractical.service.dto.OrderCreatedEvent;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderId;

    private String product;

    private Integer quantity;

    private BigDecimal price;

    public OrderResponseDTO toDTO() {
        return new OrderResponseDTO(
                this.product,
                this.quantity,
                this.price
        );
    }

    public OrderCreatedEvent toOrderCreatedEvent() {
        return new OrderCreatedEvent(
                this.product,
                this.quantity,
                this.price.toString()
        );
    }
}
