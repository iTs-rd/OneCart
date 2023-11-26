package com.onecart.OrderService.external.dto.response.payment;

import com.onecart.OrderService.external.model.Transaction;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@ToString
public class GetPaymentByIdResponse {

    public String message;
    public String status;
    public LocalDateTime timestamp;
    public ZoneId timeZone;
    private Transaction transaction;
}
