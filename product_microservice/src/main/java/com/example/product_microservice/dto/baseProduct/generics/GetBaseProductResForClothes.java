package com.example.product_microservice.dto.baseProduct.generics;

import com.example.product_microservice.dto.baseProduct.GetBaseProductResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBaseProductResForClothes extends  GetBaseProductResponse {
    private int  color_id;
}
