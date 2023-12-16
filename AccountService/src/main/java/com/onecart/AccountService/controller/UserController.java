package com.onecart.AccountService.controller;

import com.onecart.AccountService.dto.request.CreateUserRequest;
import com.onecart.AccountService.dto.request.UpdateUserRequest;
import com.onecart.AccountService.dto.response.userResponse.CreateUserResponse;
import com.onecart.AccountService.dto.response.userResponse.GetUserByIdResponse;
import com.onecart.AccountService.dto.response.userResponse.UpdateUserResponse;
import com.onecart.AccountService.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/account")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        log.info("UserController -> Creating New User : " + createUserRequest);
        return new ResponseEntity<>(userService.createUser(createUserRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest updateUserRequest) {
        log.info("UserController -> Updating User UserID : " + id + " Data : " + updateUserRequest);
        return new ResponseEntity<>(userService.updateUser(id, updateUserRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserByIdResponse> getUserById(@PathVariable Long id) {
        log.info("UserController -> Fetching User data for UserID : " + id);
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthcheck() {
        String message = "Account Service is healthy";
        log.info(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
