package com.example.product_microservice.response.base.generics;

import com.example.product_microservice.response.base.GetBaseProductResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetBaseProductResForElec<T,Y> extends GetBaseProductResponse {
    private T feature_one;
    private Y feature_tow;
}
