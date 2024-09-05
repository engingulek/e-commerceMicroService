package com.example.product_microservice.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetBaseProductResponse {
    private List<String> imageUrl;
    private String name;
    private BigDecimal price;
}
