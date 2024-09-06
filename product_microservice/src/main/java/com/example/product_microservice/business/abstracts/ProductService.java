package com.example.product_microservice.business.abstracts;

import java.util.List;

import com.example.product_microservice.dto.GetBaseProductResponse;
import com.example.product_microservice.dto.GetSmartPhoneResponse;

public interface  ProductService {
    List<GetBaseProductResponse<GetSmartPhoneResponse>> getSmartPhonesBaseResponse();
}
