package com.onecart.OrderService.controller;

import com.onecart.OrderService.dto.request.PlaceOrderRequest;
import com.onecart.OrderService.dto.response.GetAllOrderByUserIdResponse;
import com.onecart.OrderService.dto.response.GetOrderByIdResponse;
import com.onecart.OrderService.dto.response.PlaceOrderResponse;
import com.onecart.OrderService.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public ResponseEntity<PlaceOrderResponse> placeOrder(@Valid @RequestBody PlaceOrderRequest placeOrderRequest) {
        log.info("OrderController -> Placing new Order of UserId : " + placeOrderRequest.getUserId() + " and ProductID : " + placeOrderRequest.getProductId());
        return new ResponseEntity<>(orderService.placeOrder(placeOrderRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetOrderByIdResponse> getOrderById(@PathVariable Long id) {
        log.info("OrderController -> Fetching Order Details for OrderID : " + id);
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<GetAllOrderByUserIdResponse> getAllOrderByUserId(@PathVariable Long id) {
        log.info("OrderController -> Fetching All Order for a user" + id);
        return new ResponseEntity<>(orderService.getAllOrderByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthcheck() {
        String message = "Order Service is healthy";
        log.info(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
