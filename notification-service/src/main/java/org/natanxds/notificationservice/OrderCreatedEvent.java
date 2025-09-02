package org.natanxds.notificationservice;

import java.util.UUID;

public record OrderCreatedEvent(
        UUID orderId,
        String product,
        Integer quantity,
        String price
) {
}
