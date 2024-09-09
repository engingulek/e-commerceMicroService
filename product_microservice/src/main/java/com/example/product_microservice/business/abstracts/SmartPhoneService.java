package com.example.product_microservice.business.abstracts;

import com.example.product_microservice.dto.smartPhone.GetSmartPhoneDetailResponse;

public interface  SmartPhoneService {
    GetSmartPhoneDetailResponse getSmartPhoneDetail(int productId,int id); 
}
