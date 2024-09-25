package com.example.product_microservice.business.abstracts;

import java.util.List;

import com.example.product_microservice.entity.MemorySize;
import com.example.product_microservice.response.base.GetBaseFeatureResponse;
import com.example.product_microservice.response.base.GetBaseProductResponse;


public interface  ProductService {
     List<GetBaseProductResponse> getSmartPhonesBaseResponse();
     List<GetBaseProductResponse> getLaptops();
     List<GetBaseProductResponse> getThirsts();
     List<GetBaseProductResponse> getJumpers();
     List<MemorySize> getAllMemorySize();
     List<GetBaseFeatureResponse> getAllColor();
}

