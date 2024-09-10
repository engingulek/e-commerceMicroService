package com.example.inventory_microservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory_microservice.business.abstracts.InventoryService;
import com.example.inventory_microservice.dto.GetItemResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/inventory/")
@AllArgsConstructor
@NoArgsConstructor
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("getInventoryByProductId")
    public List<GetItemResponse> getInventoryByProductId(@RequestParam int productId){
        return  inventoryService.getInventoryByProductId(productId);
    }
}
