package com.onecart.OrderService.external.client;


import com.onecart.OrderService.external.dto.request.product.GetProductDataFromIDsRequest;
import com.onecart.OrderService.external.dto.request.product.ReduceQuantityRequest;
import com.onecart.OrderService.external.dto.response.product.GetProductByIdResponse;
import com.onecart.OrderService.external.dto.response.product.GetProductDataFromIDsResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "PRODUCT-SERVICE/product")
public interface ProductService {

    @PostMapping("/reduceQuantity")
    ResponseEntity<Void> reduceQuantity(@Valid @RequestBody ReduceQuantityRequest reduceQuantityRequest);

    @GetMapping("/{id}")
    public ResponseEntity<GetProductByIdResponse> getProductById(@PathVariable Long id);


    @PostMapping("/bulk")
    public ResponseEntity<GetProductDataFromIDsResponse> getProductDataFromIDs(@RequestBody GetProductDataFromIDsRequest getProductDataFromIDsRequest);

}
