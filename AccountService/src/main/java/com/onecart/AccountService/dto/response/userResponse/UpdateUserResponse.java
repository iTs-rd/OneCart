package com.onecart.AccountService.dto.response.userResponse;

import com.onecart.AccountService.models.User;

public class UpdateUserResponse extends UserGlobalResponse {
    public UpdateUserResponse(User user, String message, String status) {
        super(user, message, status);
    }
}
