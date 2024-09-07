package com.example.product_microservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_microservice.entity.Laptop;

public interface LaptopRepository extends  JpaRepository<Laptop, Integer> {
    Laptop findFirstByProductIdAndId(int productId, int id);
}
