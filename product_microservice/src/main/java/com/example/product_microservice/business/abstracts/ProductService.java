package com.example.product_microservice.business.abstracts;

import java.util.List;

import com.example.product_microservice.dto.baseProduct.GetBaseProductResponse;

public interface  ProductService {
    List<GetBaseProductResponse> getAll();
    List<GetBaseProductResponse> getSmartPhonesBaseResponse();
    List<GetBaseProductResponse> getLaptops();
   
    
}
