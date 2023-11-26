package com.onecart.OrderService.external.dto.response.product;

import com.onecart.OrderService.external.model.Product;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@ToString
public class GetProductByIdResponse {

    public String message;
    public String status;
    public LocalDateTime timestamp;
    public ZoneId timeZone;
    private Product product;

}
