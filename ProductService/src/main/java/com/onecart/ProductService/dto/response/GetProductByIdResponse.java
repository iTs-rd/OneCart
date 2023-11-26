package com.onecart.ProductService.dto.response;

import com.onecart.ProductService.models.Product;
import lombok.Data;

@Data
public class GetProductByIdResponse extends GlobalResponse {

    private final Product product;

    public GetProductByIdResponse(Product product, String message, String status) {
        super(message, status);
        this.product = product;
    }
}
