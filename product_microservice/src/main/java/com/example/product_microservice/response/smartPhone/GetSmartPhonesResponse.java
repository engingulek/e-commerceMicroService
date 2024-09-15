package com.example.product_microservice.response.smartPhone;


import java.math.BigDecimal;

import com.example.product_microservice.entity.Color;
import com.example.product_microservice.entity.MemorySize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSmartPhonesResponse {
    private int id;
    private BigDecimal price;
    private Color color;
    private MemorySize memorySize;
}
