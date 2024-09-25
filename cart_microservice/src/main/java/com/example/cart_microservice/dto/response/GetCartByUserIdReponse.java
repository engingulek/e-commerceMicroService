package com.example.cart_microservice.dto.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCartByUserIdReponse {
    private int id;
    private int productId; 
    private int subProductId;
    private String name;
    private List<String> imageUrl;
    private BigDecimal price;
    private int quantity;
}
