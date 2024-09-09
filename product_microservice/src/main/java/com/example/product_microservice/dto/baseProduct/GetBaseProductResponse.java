package com.example.product_microservice.dto.baseProduct;

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
    private int sub_product_id;
    private BigDecimal price;
    
   
}
