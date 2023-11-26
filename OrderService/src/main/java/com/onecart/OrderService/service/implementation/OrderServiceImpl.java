package com.onecart.OrderService.service.implementation;

import com.onecart.OrderService.dto.request.PlaceOrderRequest;
import com.onecart.OrderService.dto.response.GetAllOrderByUserIdResponse;
import com.onecart.OrderService.dto.response.GetOrderByIdResponse;
import com.onecart.OrderService.dto.response.PlaceOrderResponse;
import com.onecart.OrderService.external.client.PaymentService;
import com.onecart.OrderService.external.client.ProductService;
import com.onecart.OrderService.external.dto.request.payment.DoPaymentRequest;
import com.onecart.OrderService.external.dto.request.payment.GetPaymentDataFromIDsRequest;
import com.onecart.OrderService.external.dto.request.product.GetProductDataFromIDsRequest;
import com.onecart.OrderService.external.dto.request.product.ReduceQuantityRequest;
import com.onecart.OrderService.external.dto.response.payment.DoPaymentResponse;
import com.onecart.OrderService.external.dto.response.payment.GetPaymentByIdResponse;
import com.onecart.OrderService.external.dto.response.payment.GetPaymentDataFromIDsResponse;
import com.onecart.OrderService.external.dto.response.product.GetProductByIdResponse;
import com.onecart.OrderService.external.dto.response.product.GetProductDataFromIDsResponse;
import com.onecart.OrderService.external.model.Product;
import com.onecart.OrderService.external.model.Transaction;
import com.onecart.OrderService.models.Order;
import com.onecart.OrderService.repository.OrderRepository;
import com.onecart.OrderService.service.OrderService;
import com.onecart.OrderService.utils.OrderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderUtils orderUtils;

    @Override
    public PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest) {
        // TODO: make it transactional api

        ReduceQuantityRequest reduceQuantityRequest = new ReduceQuantityRequest(placeOrderRequest.getProductId(), placeOrderRequest.getQuantity());
        log.info("OrderServiceImpl -> Calling ProductService.requiredQuantity : " + reduceQuantityRequest);
        productService.reduceQuantity(reduceQuantityRequest).getBody();

        log.info("OrderServiceImpl -> Creating Order!");
        Order order = new Order(placeOrderRequest);

        orderRepository.save(order);

        DoPaymentRequest doPaymentRequest = new DoPaymentRequest(order.getId(), placeOrderRequest.getUserId(), placeOrderRequest.getAmount(), placeOrderRequest.getCurrency());
        log.info("OrderServiceImpl -> Calling PaymentService.doPayment : " + doPaymentRequest);
        ResponseEntity<DoPaymentResponse> doPaymentResponse = paymentService.doPayment(doPaymentRequest);

        order.setPaymentId(Objects.requireNonNull(doPaymentResponse.getBody()).getTransaction().getId());
        orderRepository.save(order);
        log.info("OrderServiceImpl -> Order Placed, OrderID : " + order.getId());
        return new PlaceOrderResponse(order, "Order Placed", "success");
    }

    @Override
    public GetOrderByIdResponse getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isEmpty()) {
            log.info("OrderServiceImpl -> Order Not Found, OrderID : " + id);
            throw new RuntimeException("order not found");
        }
        Order order = optionalOrder.get();

        ResponseEntity<GetPaymentByIdResponse> getPaymentByIdResponse = paymentService.getPaymentById(order.getPaymentId());
        Transaction transaction = Objects.requireNonNull(getPaymentByIdResponse.getBody()).getTransaction();

        ResponseEntity<GetProductByIdResponse> getProductByIdResponse = productService.getProductById(order.getProductId());
        Product product = Objects.requireNonNull(getProductByIdResponse.getBody()).getProduct();

        //        TODO: Add Payment detail and Product details
        log.info("OrderServiceImpl -> Order Found, OrderId : " + id);
        return new GetOrderByIdResponse(order, transaction, product, "Order Found", "success");
    }

    @Override
    public GetAllOrderByUserIdResponse getAllOrderByUserId(Long id) {
        System.out.println("sbvkufbvkse");

        List<Order> orders = orderRepository.findByUserId(id);

        //        System.out.println(orders);
        Set<Long> paymentIDs = new HashSet<>();
        Set<Long> productIDs = new HashSet<>();
        Map<Long, Transaction> transactionMap = new HashMap<>();
        Map<Long, Product> productMap = new HashMap<>();

        for (Order order : orders) {
            paymentIDs.add(order.getPaymentId());
            productIDs.add(order.getProductId());
        }

        ResponseEntity<GetPaymentDataFromIDsResponse> response = paymentService.getPaymentDataFromIDs(new GetPaymentDataFromIDsRequest(paymentIDs));
        for (Transaction transaction : Objects.requireNonNull(response.getBody()).getTransactions()) {
            transactionMap.put(transaction.getId(), transaction);
        }

        GetProductDataFromIDsRequest getProductDataFromIDsRequest = new GetProductDataFromIDsRequest(productIDs);

        ResponseEntity<GetProductDataFromIDsResponse> responseEntity = productService.getProductDataFromIDs(getProductDataFromIDsRequest);

        for (Product product : Objects.requireNonNull(responseEntity.getBody()).getProducts()) {
            productMap.put(product.getProductId(), product);
        }

        GetAllOrderByUserIdResponse getAllOrderByUserIdResponse = orderUtils.prepareGetAllOrderByUserIdResponse(orders, productMap, transactionMap);

        System.out.println(transactionMap);

        System.out.println(productMap);


        return getAllOrderByUserIdResponse;
    }
}
