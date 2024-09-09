package com.example.product_microservice.dto.laptop;

import com.example.product_microservice.dto.baseProduct.GetBaseProductDetailResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GetLaptopDetailResponse  extends  GetBaseProductDetailResponse{
    private int memory_size_id;
    
}
