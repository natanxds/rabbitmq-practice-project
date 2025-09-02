package org.natanxds.rabbitmqpractical.util;

import org.springframework.amqp.rabbit.core.RabbitAdmin;

public class Constants {

    public static final String ORDER_CREATED_QUEUE_SEND_NOTIFICATION = "orders.v1.order-created.send-notification";
    public static final String ORDER_CREATED_QUEUE_GENERATE_CASHBACK = "orders.v1.order-created.generate-cashback";
    public static final String ORDER_CREATED_EXCHANGE = "orders.v1.order-created";
}
