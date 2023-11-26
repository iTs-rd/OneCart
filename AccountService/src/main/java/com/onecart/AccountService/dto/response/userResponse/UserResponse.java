package com.onecart.AccountService.dto.response.userResponse;

import com.onecart.AccountService.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private String gender;
    private List<OrderResponse> orderResponseList;


    public UserResponse(User user, List<OrderResponse> orderResponseList) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.phoneNo = user.getPhoneNo();
        this.email = user.getEmail();
        this.gender = user.getGender();
        this.orderResponseList = orderResponseList;

    }
}
