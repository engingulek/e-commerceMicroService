package com.example.product_microservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_microservice.entity.MemorySize;

public interface  MemorySizeRepository extends  JpaRepository<MemorySize, Integer> {

}
