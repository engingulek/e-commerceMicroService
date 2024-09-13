package com.example.inventory_microservice.business.abstracts;



import org.springframework.http.ResponseEntity;

import com.example.inventory_microservice.core.results.Result;


public interface InventoryService {
    ResponseEntity<Result> getInventoryByProductId(int product_id);
}
