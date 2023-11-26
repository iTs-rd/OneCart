package com.onecart.ProductService.service;

import com.onecart.ProductService.dto.request.CreateProductRequest;
import com.onecart.ProductService.dto.request.GetProductDataFromIDsRequest;
import com.onecart.ProductService.dto.request.ReduceQuantityRequest;
import com.onecart.ProductService.dto.request.UpdateProductQuantityRequest;
import com.onecart.ProductService.dto.response.CreateProductResponse;
import com.onecart.ProductService.dto.response.GetProductByIdResponse;
import com.onecart.ProductService.dto.response.GetProductDataFromIDsResponse;
import com.onecart.ProductService.dto.response.UpdateProductQuantityResponse;

public interface ProductService {

    CreateProductResponse createProduct(CreateProductRequest createProductRequest);

    UpdateProductQuantityResponse updateProductQuantity(UpdateProductQuantityRequest updateProductQuantityRequest);

    void reduceQuantity(ReduceQuantityRequest reduceQuantityRequest);

    GetProductByIdResponse getProductById(Long id);

    GetProductDataFromIDsResponse getProductDataFromIDs(GetProductDataFromIDsRequest getProductDataFromIDsRequest);
}
