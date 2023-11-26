package com.onecart.OrderService.external.dto.response.payment;

import com.onecart.OrderService.external.model.Transaction;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Data
public class GetPaymentDataFromIDsResponse {

    public String message;
    public String status;
    public LocalDateTime timestamp;
    public ZoneId timeZone;
    List<Transaction> transactions;

}
