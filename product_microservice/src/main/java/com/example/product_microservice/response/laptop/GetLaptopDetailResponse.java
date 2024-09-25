package com.example.product_microservice.response.laptop;

import com.example.product_microservice.response.base.GetBaseProductDetailResponse;

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
