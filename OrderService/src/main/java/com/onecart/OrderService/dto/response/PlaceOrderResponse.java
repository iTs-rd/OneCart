package com.onecart.OrderService.dto.response;

import com.onecart.OrderService.models.Order;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PlaceOrderResponse extends GlobalResponse {

    private final Order order;

    public PlaceOrderResponse(Order order, String message, String status) {
        super(message, status);
        this.order = order;
    }
}
