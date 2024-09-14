package com.example.product_microservice.dto.clothes;

import java.math.BigDecimal;
import java.util.List;

import com.example.product_microservice.entity.ClotheColor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetClothesResponse {
    private int id;
    private List<String> imageUrl;
    private String name;
    private BigDecimal price;
    private ClotheColor color;
    
}
