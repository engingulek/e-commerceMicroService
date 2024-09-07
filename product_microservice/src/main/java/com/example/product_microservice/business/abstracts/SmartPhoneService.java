package com.example.product_microservice.business.abstracts;

import com.example.product_microservice.dto.ProductDetailResponse;

public interface  SmartPhoneService {
    ProductDetailResponse getSmartPhoneDetail(int productId,int id); 
}
