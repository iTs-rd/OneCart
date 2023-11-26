package com.onecart.PaymentService.dto.response;

import com.onecart.PaymentService.models.Transaction;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DoPaymentResponse extends GlobalResponse {

    private final Transaction transaction;

    public DoPaymentResponse(Transaction transaction, String message, String status) {
        super(message, status);
        this.transaction = transaction;
    }
}
