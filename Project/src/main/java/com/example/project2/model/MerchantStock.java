package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@AllArgsConstructor @Data
public class MerchantStock {
    @NotNull(message = "ID must not be null")
    @Range(min = 3,message="ID must be more than 2")
    private int ID;
    @NotNull(message = "productID must not be null")
    @Range(min = 3,message="ProductId must be more than 2")
    private int producid;
    @NotNull(message = "Merchant ID must not be null")
    @Range(min = 3,message="Merchant ID must be more than 2")
    private int merchantid;
    @NotNull(message = " Stock should not be null")
    @Range(min = 10,message="Stock must be more than 10 at start")
    private int stock;


}
