package com.onecart.ProductService.controller;

import com.onecart.ProductService.dto.request.CreateProductRequest;
import com.onecart.ProductService.dto.request.GetProductDataFromIDsRequest;
import com.onecart.ProductService.dto.request.ReduceQuantityRequest;
import com.onecart.ProductService.dto.request.UpdateProductQuantityRequest;
import com.onecart.ProductService.dto.response.CreateProductResponse;
import com.onecart.ProductService.dto.response.GetProductByIdResponse;
import com.onecart.ProductService.dto.response.GetProductDataFromIDsResponse;
import com.onecart.ProductService.dto.response.UpdateProductQuantityResponse;
import com.onecart.ProductService.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<CreateProductResponse> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        log.info("ProductController -> Creating new Product!");
        return new ResponseEntity<>(productService.createProduct(createProductRequest), HttpStatus.CREATED);
    }

    @PostMapping("/updateProductQuantity")
    public ResponseEntity<UpdateProductQuantityResponse> updateProductQuantity(@Valid @RequestBody UpdateProductQuantityRequest updateProductQuantityRequest) {
        log.info("ProductController -> Updating Product Quantity : " + updateProductQuantityRequest);
        return new ResponseEntity<>(productService.updateProductQuantity(updateProductQuantityRequest), HttpStatus.OK);
    }

    @PostMapping("/reduceQuantity")
    public ResponseEntity<Void> reduceQuantity(@Valid @RequestBody ReduceQuantityRequest reduceQuantityRequest) {
        log.info("ProductController -> Reducing Quantity : " + reduceQuantityRequest);
        productService.reduceQuantity(reduceQuantityRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductByIdResponse> getProductById(@PathVariable Long id) {
        log.info("ProductController -> Fetching Product for ProductId : " + id);
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/bulk")
    public ResponseEntity<GetProductDataFromIDsResponse> getProductDataFromIDs(@RequestBody GetProductDataFromIDsRequest getProductDataFromIDsRequest) {
        log.info("ProductController");
        return new ResponseEntity<>(productService.getProductDataFromIDs(getProductDataFromIDsRequest), HttpStatus.OK);
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthcheck() {
        String message = "Product Service is healthy";
        log.info(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
