package com.onecart.ProductService.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UpdateProductQuantityRequest {

    @NotNull
    private Long productId;

    @NotNull
    @Size(min = 2)
    private String productName;

    @NotNull
    private Long price;

    @NotNull
    private String currency;

    @Min(1)
    private Long quantity;
}
