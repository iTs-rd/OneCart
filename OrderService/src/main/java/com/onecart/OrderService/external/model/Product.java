package com.onecart.OrderService.external.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {

    private long productId;

    private String productName;

    private Long price;

    private String currency;

    @JsonIgnore
    private Long quantity;

}
