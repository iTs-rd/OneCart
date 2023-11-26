package com.onecart.AccountService.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateUserRequest {

    @JsonIgnore
    private final String firstNameMessage = "First Name Should be between 1 to 256 characters";
    @JsonIgnore
    private final String lastNameMessage = "Last Name Should be between 1 to 256 characters";
    @JsonIgnore
    private final String phoneNoMessage = "Phone no Should be of 10 digit";


    @NotNull(message = firstNameMessage)
    @Size(min = 2, max = 256, message = firstNameMessage)
    private String firstName;

    @NotNull(message = lastNameMessage)
    @Size(min = 1, max = 256, message = lastNameMessage)
    private String lastName;

    @NotNull(message = phoneNoMessage)
    @Size(min = 10, max = 10, message = phoneNoMessage)
    private String phoneNo;

    @Size(min = 4, max = 256)
    private String password;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String gender;


}
