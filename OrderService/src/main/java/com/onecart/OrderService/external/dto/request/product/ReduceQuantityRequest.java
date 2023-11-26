package com.onecart.OrderService.external.dto.request.product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReduceQuantityRequest {

    @NotNull
    private Long productId;

    @NotNull
    private Long quantity;
}
