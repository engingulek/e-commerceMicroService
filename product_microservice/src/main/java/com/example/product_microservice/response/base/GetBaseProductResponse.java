package com.example.product_microservice.response.base;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetBaseProductResponse {
    private int id;
    private List<String> imageurl;
    private String name;
    private BigDecimal price;
 
}
