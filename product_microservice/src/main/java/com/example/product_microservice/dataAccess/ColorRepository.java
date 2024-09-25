package com.example.product_microservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_microservice.entity.Color;

public interface ColorRepository  extends  JpaRepository<Color,Integer>{

}
