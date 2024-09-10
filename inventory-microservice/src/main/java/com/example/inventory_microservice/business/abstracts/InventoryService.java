package com.example.inventory_microservice.business.abstracts;

import java.util.List;

import com.example.inventory_microservice.dto.GetItemResponse;

public interface InventoryService {
    List<GetItemResponse> getInventoryByProductId(int product_id);
}
