package com.onecart.OrderService.utils;

import com.onecart.OrderService.dto.response.GetAllOrderByUserIdResponse;
import com.onecart.OrderService.dto.response.OrderResponse;
import com.onecart.OrderService.external.model.Product;
import com.onecart.OrderService.external.model.Transaction;
import com.onecart.OrderService.models.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OrderUtils {
    public GetAllOrderByUserIdResponse prepareGetAllOrderByUserIdResponse(List<Order> orders, Map<Long, Product> productMap, Map<Long, Transaction> transactionMap) {

        List<OrderResponse> orderResponseList = new ArrayList<>();

        for(Order order : orders) {
            orderResponseList.add(new OrderResponse(order, transactionMap.get(order.getPaymentId()), productMap.get(order.getProductId())));
        }

        return new GetAllOrderByUserIdResponse(orderResponseList, "done", "success");
    }
}
