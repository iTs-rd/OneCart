package com.onecart.ProductService.dto.response;

import com.onecart.ProductService.models.Product;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UpdateProductQuantityResponse extends GlobalResponse {

    private final Product product;

    public UpdateProductQuantityResponse(Product product, String message, String status) {
        super(message, status);
        this.product = product;
    }
}
