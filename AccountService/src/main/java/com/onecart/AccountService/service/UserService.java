package com.onecart.AccountService.service;

import com.onecart.AccountService.dto.request.CreateUserRequest;
import com.onecart.AccountService.dto.request.UpdateUserRequest;
import com.onecart.AccountService.dto.response.userResponse.CreateUserResponse;
import com.onecart.AccountService.dto.response.userResponse.GetUserByIdResponse;
import com.onecart.AccountService.dto.response.userResponse.UpdateUserResponse;

public interface UserService {

    CreateUserResponse createUser(CreateUserRequest createUserRequest);

    UpdateUserResponse updateUser(Long id, UpdateUserRequest updateUserRequest);

    GetUserByIdResponse getUserById(Long id);

}
