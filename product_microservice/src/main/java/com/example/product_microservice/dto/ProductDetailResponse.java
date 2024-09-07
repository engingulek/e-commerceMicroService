package com.example.product_microservice.dto;


import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailResponse {
    private int  id;
    private int product_id;
    private String name;
    private List<String> imageurl;
    private String  description;
    private BigDecimal price;
    
}
