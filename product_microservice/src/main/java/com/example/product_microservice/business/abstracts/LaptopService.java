package com.example.product_microservice.business.abstracts;

import com.example.product_microservice.dto.ProductDetailResponse;

public interface LaptopService {
    ProductDetailResponse getLaptopDetail(int productId,int id); 
}
