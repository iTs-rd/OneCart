package com.onecart.OrderService.external.dto.response.product;

import com.onecart.OrderService.external.model.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Data
public class GetProductDataFromIDsResponse {

    public String message;
    public String status;
    public LocalDateTime timestamp;
    public ZoneId timeZone;
    List<Product> products;

}
