package com.example.product_microservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetBaseProductResponse<T> {
    private int id;
    private List<String> imageurl;
    private String name;
    private List<T> subProducts;
}
