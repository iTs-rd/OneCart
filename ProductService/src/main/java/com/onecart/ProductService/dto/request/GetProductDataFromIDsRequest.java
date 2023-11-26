package com.onecart.ProductService.dto.request;

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
