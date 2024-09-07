package com.example.product_microservice.dto;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSubProductResponse {
    private int id;
    private BigDecimal price;
    private String colorName;
    private String size;
   /* private int memory_size_id;
    private String size;*/
    

  
}
