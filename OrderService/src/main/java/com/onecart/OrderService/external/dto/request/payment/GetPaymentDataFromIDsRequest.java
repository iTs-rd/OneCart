package com.onecart.OrderService.external.dto.request.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentDataFromIDsRequest {
    Set<Long> IDs;

}
