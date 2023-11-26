package com.onecart.AccountService.external.dto.response;

import com.onecart.AccountService.dto.response.userResponse.OrderResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Data
@NoArgsConstructor
public class GetAllOrderByUserIdResponse {

    public String message;
    public String status;
    public LocalDateTime timestamp;
    public ZoneId timeZone;
    private List<OrderResponse> orderResponseList;

}
