package com.example.inventory_microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetItemResponse {
    private String id;
    private  int  color_id;
    private  int  memory_size_id;
    private int stock_quantity;
}
