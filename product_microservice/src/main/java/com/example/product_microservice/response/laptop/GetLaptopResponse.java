package com.example.product_microservice.response.laptop;

import java.math.BigDecimal;

import com.example.product_microservice.entity.MemorySize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLaptopResponse {
    private int id;
    private BigDecimal price;
    private MemorySize memorySize;
    private int ram_capacity;
    private String operating_system;
}
