package com.onecart.AccountService.dto.response.userResponse;

import com.onecart.AccountService.dto.response.GlobalResponse;
import com.onecart.AccountService.models.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
public class GetUserByIdResponse extends GlobalResponse {


    private UserResponse user;


    public GetUserByIdResponse(User user, List<OrderResponse> orderResponseList, String message, String status) {
        super(message, status);
        this.user = new UserResponse(user, orderResponseList);
    }
}

