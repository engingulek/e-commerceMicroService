package com.example.product_microservice.response.base.subBase;

import com.example.product_microservice.response.base.GetBaseProductResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetBaseProductResForSmartPhone extends GetBaseProductResponse {
    private int memory_size_id;
    private int  color_id;
}
