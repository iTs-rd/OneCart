package com.onecart.PaymentService.dto.response;

import com.onecart.PaymentService.models.Transaction;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GetPaymentByIdResponse extends GlobalResponse {

    private final Transaction transaction;

    public GetPaymentByIdResponse(Transaction transaction, String message, String status) {
        super(message, status);
        this.transaction = transaction;
    }
}
