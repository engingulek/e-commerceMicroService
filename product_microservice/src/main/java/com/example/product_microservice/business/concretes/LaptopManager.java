package com.example.product_microservice.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.product_microservice.business.abstracts.LaptopService;
import com.example.product_microservice.core.results.Result;
import com.example.product_microservice.core.results.SuccessDataResult;
import com.example.product_microservice.dataAccess.LaptopRepository;
import com.example.product_microservice.entity.Laptop;
import com.example.product_microservice.response.laptop.GetLaptopDetailResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class LaptopManager implements  LaptopService {
    
    @Autowired
    private LaptopRepository laptopRepository;
    @Override
    public ResponseEntity<Result> getLaptopDetail(int productId, int id) {
        Laptop laptop = laptopRepository.findFirstByProductIdAndId(productId, id);
        GetLaptopDetailResponse getLaptopDetailResponse = new GetLaptopDetailResponse();
        getLaptopDetailResponse.setId(laptop.getId());
        getLaptopDetailResponse.setProduct_id(laptop.getProduct().getId());
        String size = laptop.getMemorySize().getSize()+"GB";
         if("1000".equals(laptop.getMemorySize().getSize())){
            size = "1TB";
        }
        String name =laptop.getProduct().getName()+ " " +size + " " + laptop.getRam_capacity();
        getLaptopDetailResponse.setName(name);
        getLaptopDetailResponse.setImageurl(laptop.getProduct().getImageUrl());
        getLaptopDetailResponse.setDescription(laptop.getProduct().getDescription());
        getLaptopDetailResponse.setPrice(laptop.getPrice());
        getLaptopDetailResponse.setMemory_size_id(laptop.getMemorySize().getId());
        return ResponseEntity.ok(new SuccessDataResult<>(getLaptopDetailResponse,true, "fetch successful")) ;
    }

}
