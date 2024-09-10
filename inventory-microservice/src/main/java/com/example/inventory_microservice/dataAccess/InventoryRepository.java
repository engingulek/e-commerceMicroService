package com.example.inventory_microservice.dataAccess;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.inventory_microservice.entity.Item;

public interface InventoryRepository extends MongoRepository<Item, String> {
    List<Item> findByProductId(int product_id);
}
