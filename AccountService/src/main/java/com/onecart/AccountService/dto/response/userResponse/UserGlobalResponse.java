package com.onecart.AccountService.dto.response.userResponse;

import com.onecart.AccountService.dto.response.GlobalResponse;
import com.onecart.AccountService.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGlobalResponse extends GlobalResponse {
    private User user;

    public UserGlobalResponse(User user, String message, String status) {
        super(message, status);
        this.user = user;
    }
}
