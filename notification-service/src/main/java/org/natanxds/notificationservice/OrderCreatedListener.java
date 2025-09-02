package org.natanxds.notificationservice;

import org.natanxds.notificationservice.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedListener {

    @RabbitListener(queues = "orders.v1.order-created.send-notification")
    public void onOrderCreated(OrderCreatedEvent message){
        System.out.println("Received order created message: " + new String(message.toString()));
    }
}
