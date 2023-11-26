package com.onecart.OrderService.external.model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@ToString
public class Transaction {

    private Long id;

    private Long orderId;

    private Long userId;

    private Long amount;

    private String currency;

    private String paymentStatus;

    private LocalDateTime paymentDatetime;

    private ZoneId timeZone;

}
