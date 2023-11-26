package com.onecart.OrderService.dto.response;

import com.onecart.OrderService.external.model.Product;
import com.onecart.OrderService.external.model.Transaction;
import com.onecart.OrderService.models.Order;
import lombok.Data;


@Data
public class GetOrderByIdResponse extends GlobalResponse {

    private final OrderResponse order;


    public GetOrderByIdResponse(Order order, Transaction transaction, Product product, String message, String status) {
        super(message, status);
        this.order = new OrderResponse(order, transaction, product);

    }


}
