package com.example.product_microservice.dto.laptop;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLaptopResponse {
    private int id;
    private BigDecimal price;
    private String size;
    private int ram_capacity;
    private String operating_system;
}
