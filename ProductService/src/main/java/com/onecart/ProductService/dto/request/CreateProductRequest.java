package com.onecart.ProductService.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class CreateProductRequest {

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
