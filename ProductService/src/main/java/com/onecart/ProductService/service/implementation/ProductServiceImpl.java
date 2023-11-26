package com.onecart.ProductService.service.implementation;

import com.onecart.ProductService.dto.request.CreateProductRequest;
import com.onecart.ProductService.dto.request.GetProductDataFromIDsRequest;
import com.onecart.ProductService.dto.request.ReduceQuantityRequest;
import com.onecart.ProductService.dto.request.UpdateProductQuantityRequest;
import com.onecart.ProductService.dto.response.CreateProductResponse;
import com.onecart.ProductService.dto.response.GetProductByIdResponse;
import com.onecart.ProductService.dto.response.GetProductDataFromIDsResponse;
import com.onecart.ProductService.dto.response.UpdateProductQuantityResponse;
import com.onecart.ProductService.models.Product;
import com.onecart.ProductService.repository.ProductRepository;
import com.onecart.ProductService.service.ProductService;
import com.onecart.ProductService.utils.ProductUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductUtils productUtils;

    @Override
    public CreateProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product = new Product(createProductRequest);
        productRepository.save(product);
        log.info("ProductServiceImpl -> Product Created : " + product);
        return new CreateProductResponse(product, "Product Created!", "success");
    }

    @Override
    public UpdateProductQuantityResponse updateProductQuantity(UpdateProductQuantityRequest updateProductQuantityRequest) {
        Optional<Product> optionalProduct = productRepository.findById(updateProductQuantityRequest.getProductId());

        if (optionalProduct.isEmpty()) {
            log.info("ProductServiceImpl -> Product Not Found for ProductId : " + updateProductQuantityRequest.getProductId());
            throw new RuntimeException("Product Not Found");
        }

        updateProductQuantityRequest.setQuantity(updateProductQuantityRequest.getQuantity() + optionalProduct.get().getQuantity());

        Product product = new Product(updateProductQuantityRequest);

        productRepository.save(product);

        log.info("ProductServiceImpl -> Product Updated successfully " + product);

        return new UpdateProductQuantityResponse(product, "Product Updated successfully", "success");
    }

    @Override
    public void reduceQuantity(ReduceQuantityRequest reduceQuantityRequest) {
        Optional<Product> optionalProduct = productRepository.findById(reduceQuantityRequest.getProductId());

        if (optionalProduct.isEmpty()) {
            log.info("ProductServiceImpl -> Product not Found for Product ID : " + reduceQuantityRequest.getProductId());
            throw new RuntimeException("Product not found");
        }

        Product product = optionalProduct.get();

        if (!productUtils.checkForSufficientQuantity(product.getQuantity(), reduceQuantityRequest.getQuantity())) {
            log.info("ProductServiceImpl -> Product Quantity is Not Sufficient for ProductID : " + reduceQuantityRequest.getProductId());
            throw new RuntimeException("InSufficient Product Quantity");
        }

        product.setQuantity(product.getQuantity() - reduceQuantityRequest.getQuantity());
        productRepository.save(product);

        log.info("ProductServiceImpl -> Quantity Reduced For ProductID : " + reduceQuantityRequest.getProductId());
    }

    @Override
    public GetProductByIdResponse getProductById(Long id) {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            log.info("ProductServiceImpl -> Product not Found for Product ID : " + id);
            throw new RuntimeException("Product not found");
        }

        log.info("ProductServiceImpl -> Product Found : " + optionalProduct.get());
        return new GetProductByIdResponse(optionalProduct.get(), "Product Found", "success");
    }

    @Override
    public GetProductDataFromIDsResponse getProductDataFromIDs(GetProductDataFromIDsRequest getProductDataFromIDsRequest) {
        List<Product> products = productRepository.findAllById(getProductDataFromIDsRequest.getIDs());

        System.out.println(products);

        return new GetProductDataFromIDsResponse(products, "found", "success");
    }
}
