package com.onecart.OrderService.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

//@EqualsAndHashCode(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class GetAllOrderByUserIdResponse extends GlobalResponse {

    private List<OrderResponse> orderResponseList;

    public GetAllOrderByUserIdResponse(List<OrderResponse> orderResponseList, String message, String status) {

        super(message, status);
        this.orderResponseList = orderResponseList;
    }
}
