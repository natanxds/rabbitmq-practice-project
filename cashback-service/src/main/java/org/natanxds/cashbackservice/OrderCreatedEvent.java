package org.natanxds.cashbackservice;

import java.util.UUID;

public record OrderCreatedEvent(
        UUID orderId,
        String product,
        Integer quantity,
        String price
) {
}
