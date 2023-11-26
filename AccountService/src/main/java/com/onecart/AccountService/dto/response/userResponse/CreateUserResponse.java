package com.onecart.AccountService.dto.response.userResponse;

import com.onecart.AccountService.models.User;


public class CreateUserResponse extends UserGlobalResponse {

    public CreateUserResponse(User user, String message, String status) {
        super(user, message, status);
    }
}
