package com.example.product_microservice.response.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBaseFeatureResponse {
    private int id;
    private String name;
}
