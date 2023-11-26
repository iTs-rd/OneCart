package com.onecart.AccountService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onecart.AccountService.dto.request.CreateUserRequest;
import com.onecart.AccountService.dto.request.UpdateUserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String phoneNo;

    private String email;

    private String gender;

    @JsonIgnore
    private String password;

    public User(CreateUserRequest createUserRequest) {
        this.firstName = createUserRequest.getFirstName();
        this.lastName = createUserRequest.getLastName();
        this.phoneNo = createUserRequest.getPhoneNo();
        this.email = createUserRequest.getEmail();
        this.gender = createUserRequest.getGender();
        this.password = createUserRequest.getPassword();
    }

    public User(Long id, UpdateUserRequest updateUserRequest) {
        this.id = id;
        this.firstName = updateUserRequest.getFirstName();
        this.lastName = updateUserRequest.getLastName();
        this.phoneNo = updateUserRequest.getPhoneNo();
        this.email = updateUserRequest.getEmail();
        this.gender = updateUserRequest.getGender();
        this.password = updateUserRequest.getPassword();
    }
}
