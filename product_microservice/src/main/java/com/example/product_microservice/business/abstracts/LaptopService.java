package com.example.product_microservice.business.abstracts;


import org.springframework.http.ResponseEntity;

import com.example.product_microservice.core.results.Result;


public interface LaptopService {
     ResponseEntity<Result>  getLaptopDetail(int productId,int id); 
}
