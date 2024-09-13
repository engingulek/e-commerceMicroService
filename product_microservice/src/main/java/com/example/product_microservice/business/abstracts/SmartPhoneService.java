package com.example.product_microservice.business.abstracts;

import org.springframework.http.ResponseEntity;

import com.example.product_microservice.core.results.Result;

public interface  SmartPhoneService {
    ResponseEntity<Result>  getSmartPhoneDetail(int productId,int id); 
}
