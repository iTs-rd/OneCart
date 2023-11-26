package com.onecart.ProductService.utils;

import org.springframework.stereotype.Component;

@Component
public class ProductUtils {

    public boolean checkForSufficientQuantity(Long currentQuantity, Long requiredQuantity) {
        return currentQuantity >= requiredQuantity;
    }
}
