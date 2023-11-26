package com.onecart.PaymentService.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class GetPaymentDataFromIDsRequest {
    Set<Long> IDs;
}
