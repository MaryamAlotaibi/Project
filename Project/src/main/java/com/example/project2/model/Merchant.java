package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@AllArgsConstructor @Data
public class Merchant {
    @NotNull(message = "ID must not be null")
    @Range(min = 3,message="ID must be more than 2")
    private int ID;
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3,message="Name must be more than 3")
    private String name;
}
