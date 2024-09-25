package com.example.inventory_microservice.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.inventory_microservice.business.abstracts.InventoryService;
import com.example.inventory_microservice.core.mapper.ModelMapperService;
import com.example.inventory_microservice.core.results.Result;
import com.example.inventory_microservice.core.results.SuccessDataResult;
import com.example.inventory_microservice.dataAccess.InventoryRepository;
import com.example.inventory_microservice.dto.GetItemResponse;
import com.example.inventory_microservice.entity.Item;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class InventoryManager  implements InventoryService{
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ModelMapperService modelMapperService;
    @Override
    public ResponseEntity<Result> getInventoryByProductId(int product_id) {
        List<Item> items = inventoryRepository.findByProductId(product_id);

        List<GetItemResponse> getItemResponses = items.stream().map(item -> this.modelMapperService.forResponse()
        .map(item, GetItemResponse.class)).collect(Collectors.toList());
        
       
        return  ResponseEntity.ok(new SuccessDataResult<>(getItemResponses, true, "fetch success full"));
    }

}
