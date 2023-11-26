package com.onecart.ProductService.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ReduceQuantityRequest {

    @NotNull
    private Long productId;

    @NotNull
    private Long quantity;
}
