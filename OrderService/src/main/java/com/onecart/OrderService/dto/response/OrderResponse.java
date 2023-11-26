package com.onecart.OrderService.dto.response;


import com.onecart.OrderService.external.model.Product;
import com.onecart.OrderService.external.model.Transaction;
import com.onecart.OrderService.models.Order;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
public class OrderResponse {
    private final Long id;
    private final Long userId;
    private final Long quantity;
    private final String orderStatus;
    private final Long amount;
    private final String currency;
    private final LocalDateTime orderDatetime;
    private final ZoneId timeZone;
    private final Transaction transaction;
    private final Product product;


    public OrderResponse(Order order, Transaction transaction, Product product) {
        this.id = order.getId();
        this.userId = order.getUserId();
        this.quantity = order.getQuantity();
        this.orderStatus = order.getOrderStatus();
        this.amount = order.getAmount();
        this.currency = order.getCurrency();
        this.orderDatetime = order.getOrderDatetime();
        this.timeZone = order.getTimeZone();
        this.transaction = transaction;
        this.product = product;
    }
}

