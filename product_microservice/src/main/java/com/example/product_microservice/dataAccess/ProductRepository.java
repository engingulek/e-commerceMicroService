package com.example.product_microservice.dataAccess;
import org.springframework.data.jpa.repository.JpaRepository;
public interface  ProductRepository extends JpaRepository<Object, Integer>{
    
}
