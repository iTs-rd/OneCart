package com.onecart.OrderService.models;

import com.onecart.OrderService.dto.request.PlaceOrderRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long productId;
    private Long paymentId;
    private Long quantity;
    private String orderStatus;
    private Long amount;
    private String currency;
    private LocalDateTime orderDatetime;
    private ZoneId timeZone;

    public Order(PlaceOrderRequest placeOrderRequest) {
        this.userId = placeOrderRequest.getUserId();
        this.productId = placeOrderRequest.getProductId();
        this.quantity = placeOrderRequest.getQuantity();
        this.amount = placeOrderRequest.getAmount();
        this.currency = placeOrderRequest.getCurrency();

        this.orderDatetime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        this.timeZone = ZoneId.of("Asia/Kolkata");
        this.orderStatus = "Pending";

    }
}
