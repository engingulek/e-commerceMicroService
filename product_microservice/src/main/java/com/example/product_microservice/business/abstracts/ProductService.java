package com.example.product_microservice.business.abstracts;

import java.util.List;

import com.example.product_microservice.dto.baseProduct.GetBaseProductResponse;

public interface  ProductService {
     List<GetBaseProductResponse> getAll();
     List<GetBaseProductResponse> getSmartPhonesBaseResponse();
     List<GetBaseProductResponse> getLaptops();
     List<GetBaseProductResponse> getThirsts();
     List<GetBaseProductResponse> getJumpers();
}
