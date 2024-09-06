package com.example.product_microservice.dto;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSmartPhoneResponse {
    private int id;
    private BigDecimal price;

  
}
