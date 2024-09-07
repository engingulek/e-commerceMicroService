package com.example.product_microservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_microservice.entity.SmartPhone;

public interface SmartPhoneRepository extends  JpaRepository<SmartPhone, Integer>{
    SmartPhone findFirstByProductIdAndId(int productId, int id);
}
