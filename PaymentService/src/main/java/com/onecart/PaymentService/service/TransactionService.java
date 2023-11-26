package com.onecart.PaymentService.service;

import com.onecart.PaymentService.dto.request.DoPaymentRequest;
import com.onecart.PaymentService.dto.request.GetPaymentDataFromIDsRequest;
import com.onecart.PaymentService.dto.response.DoPaymentResponse;
import com.onecart.PaymentService.dto.response.GetPaymentByIdResponse;
import com.onecart.PaymentService.dto.response.GetPaymentDataFromIDsResponse;

public interface TransactionService {

    DoPaymentResponse doPayment(DoPaymentRequest doPaymentRequest);

    GetPaymentByIdResponse getPaymentById(Long id);

    GetPaymentDataFromIDsResponse getPaymentDataFromIDs(GetPaymentDataFromIDsRequest getPaymentDataFromIDsRequest);
}
