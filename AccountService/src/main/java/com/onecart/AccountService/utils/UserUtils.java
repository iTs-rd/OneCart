package com.onecart.AccountService.utils;

import com.onecart.AccountService.models.User;
import com.onecart.AccountService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class UserUtils {

    @Autowired
    private UserRepository userRepository;

    public boolean userAlreadyExist(String phoneNo) {
        Optional<User> user = userRepository.findByPhoneNo(phoneNo);
        return user.isPresent();
    }

    public boolean isPhoneNoMatches(String phoneNo, String phoneNo1) {
        return Objects.equals(phoneNo1, phoneNo);
    }
}
