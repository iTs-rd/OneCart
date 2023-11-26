package com.onecart.ProductService.models;

import com.onecart.ProductService.dto.request.CreateProductRequest;
import com.onecart.ProductService.dto.request.UpdateProductQuantityRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    //    TODO: Handle Duplicate entry Error
    @Column(unique = true, nullable = false)
    private String productName;

    private Long price;

    private String currency;

    private Long quantity;

    public Product(UpdateProductQuantityRequest updateProductQuantityRequest) {
        this.productId = updateProductQuantityRequest.getProductId();
        this.productName = updateProductQuantityRequest.getProductName();
        this.price = updateProductQuantityRequest.getPrice();
        this.currency = updateProductQuantityRequest.getCurrency();
        this.quantity = updateProductQuantityRequest.getQuantity();
    }

    public Product(CreateProductRequest createProductRequest) {
        this.productName = createProductRequest.getProductName();
        this.price = createProductRequest.getPrice();
        this.currency = createProductRequest.getCurrency();
        this.quantity = createProductRequest.getQuantity();
    }
}
