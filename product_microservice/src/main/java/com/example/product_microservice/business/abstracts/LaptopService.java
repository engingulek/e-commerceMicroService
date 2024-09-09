package com.example.product_microservice.business.abstracts;


import com.example.product_microservice.dto.laptop.GetLaptopDetailResponse;


public interface LaptopService {
    GetLaptopDetailResponse getLaptopDetail(int productId,int id); 
}
