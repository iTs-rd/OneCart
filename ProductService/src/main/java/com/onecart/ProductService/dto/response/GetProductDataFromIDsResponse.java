package com.onecart.ProductService.dto.response;

import com.onecart.ProductService.models.Product;
import lombok.Data;

import java.util.List;

@Data
public class GetProductDataFromIDsResponse extends GlobalResponse {
    List<Product> products;

    public GetProductDataFromIDsResponse(List<Product> products, String message, String status) {
        super(message, status);
        this.products = products;
    }
}
