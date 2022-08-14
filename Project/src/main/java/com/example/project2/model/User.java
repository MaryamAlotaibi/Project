package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class User {
    @NotNull(message = "ID must not be null")
    @Range(min = 3,message="ID must be more than 2")
    private int ID;
    @NotEmpty(message = "username must not be empty")
    @Size(min = 3,message="username must be more than 3")
    private String username;
    @NotNull(message = "ID must not be null")
    @Range(min = 3,message="ID must be more than 2")
    @Pattern (regexp = "^(?=.[0-9])(?=.[a-z])(?=.*[A-Z]).{6,}$")
    private int password;
    @NotEmpty(message = "Email must not be empty")
    @Pattern (regex = "[a-z0-9]+@[a-z]+\.")
    private String email;
    @NotEmpty
    @Pattern(regexp = "(Admin|User)",message= "role must be admin or user")
    private String role;
    @NotNull (message= "balance should not be null")
    @Positive (message="balance should be positive number")
    private double balance;
}
