package com.onecart.PaymentService.dto.response;

import com.onecart.PaymentService.models.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class GetPaymentDataFromIDsResponse extends GlobalResponse {

    List<Transaction> transactions;

    public GetPaymentDataFromIDsResponse(List<Transaction> transactions, String message, String status) {
        super(message, status);
        this.transactions = transactions;
    }
}
