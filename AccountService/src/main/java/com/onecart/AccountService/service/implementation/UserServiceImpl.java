package com.onecart.AccountService.service.implementation;

import com.onecart.AccountService.dto.request.CreateUserRequest;
import com.onecart.AccountService.dto.request.UpdateUserRequest;
import com.onecart.AccountService.dto.response.userResponse.CreateUserResponse;
import com.onecart.AccountService.dto.response.userResponse.GetUserByIdResponse;
import com.onecart.AccountService.dto.response.userResponse.OrderResponse;
import com.onecart.AccountService.dto.response.userResponse.UpdateUserResponse;
import com.onecart.AccountService.external.client.OrderService;
import com.onecart.AccountService.external.dto.response.GetAllOrderByUserIdResponse;
import com.onecart.AccountService.models.User;
import com.onecart.AccountService.repository.UserRepository;
import com.onecart.AccountService.service.UserService;
import com.onecart.AccountService.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private OrderService orderService;

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {

        if (userUtils.userAlreadyExist(createUserRequest.getPhoneNo())) {
            log.info("UserServiceImpl -> User Already Exist");
            throw new RuntimeException("user already exist");
        }

        //        TODO:Encode password

        User user = new User(createUserRequest);
        userRepository.save(user);
        log.info("UserServiceImpl -> User Created : " + user);
        return new CreateUserResponse(user, "User Created!", "success");

    }

    @Override
    public UpdateUserResponse updateUser(Long id, UpdateUserRequest updateUserRequest) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            log.info("UserServiceImpl -> User With UserID : " + id + " Not Found");
            throw new RuntimeException("user not found");
        }

        User user = optionalUser.get();

        if (!userUtils.isPhoneNoMatches(user.getPhoneNo(), updateUserRequest.getPhoneNo())) {
            log.info("UserServiceImpl -> Can't change Phone No");
            throw new RuntimeException("Cant change phone no");
        }

        //        TODO: Enode password
        if (updateUserRequest.getPassword() == null)
            updateUserRequest.setPassword(user.getPassword());

        //        TODO: Optimize
        User newUser = new User(id, updateUserRequest);
        newUser.setId(id);

        userRepository.save(newUser);

        log.info("UserServiceImpl -> User Update Successfully : " + newUser);
        return new UpdateUserResponse(newUser, "User Updated!", "success");
    }

    @Override
    public GetUserByIdResponse getUserById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            log.info("UserServiceImpl -> User With UserID : " + id + " Not Found");
            throw new RuntimeException("user not found");
        }
        User user = optionalUser.get();
        ResponseEntity<GetAllOrderByUserIdResponse> getAllOrderByUserIdResponse = orderService.getAllOrderByUserId(user.getId());
        List<OrderResponse> orderResponseList = Objects.requireNonNull(getAllOrderByUserIdResponse.getBody()).getOrderResponseList();

        log.info("UserServiceImpl -> User Found For UserID : " + id + " Data : " + optionalUser.get());
        return new GetUserByIdResponse(user, orderResponseList, "User Found!", "success");
    }

}
