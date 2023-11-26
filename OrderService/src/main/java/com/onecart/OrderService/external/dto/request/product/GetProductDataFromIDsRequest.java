package com.onecart.OrderService.external.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductDataFromIDsRequest {
    Set<Long> IDs;
}
