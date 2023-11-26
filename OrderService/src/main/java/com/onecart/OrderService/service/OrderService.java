package com.onecart.OrderService.service;

import com.onecart.OrderService.dto.request.PlaceOrderRequest;
import com.onecart.OrderService.dto.response.GetAllOrderByUserIdResponse;
import com.onecart.OrderService.dto.response.GetOrderByIdResponse;
import com.onecart.OrderService.dto.response.PlaceOrderResponse;

public interface OrderService {

    PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest);

    GetOrderByIdResponse getOrderById(Long id);

    GetAllOrderByUserIdResponse getAllOrderByUserId(Long id);

}
