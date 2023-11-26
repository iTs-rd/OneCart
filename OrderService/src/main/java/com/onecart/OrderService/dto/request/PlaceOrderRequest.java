package com.onecart.OrderService.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PlaceOrderRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Long productId;

    @NotNull
    private Long quantity;

    @NotNull
    private Long amount;

    @NotNull
    private String currency;

}
