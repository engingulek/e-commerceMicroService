package com.example.cart_microservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.cart_microservice.dto.response.GetBaseProductResponse;

@FeignClient(name="product-microservice",url="http://localhost:8082/api/product/")
public interface  ProductClient {
    @GetMapping("getAll")
    List<GetBaseProductResponse> getAll();

}
