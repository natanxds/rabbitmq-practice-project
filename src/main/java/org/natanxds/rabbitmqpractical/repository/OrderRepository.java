package org.natanxds.rabbitmqpractical.repository;

import org.natanxds.rabbitmqpractical.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
