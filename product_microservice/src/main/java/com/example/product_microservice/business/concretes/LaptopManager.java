package com.example.product_microservice.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_microservice.business.abstracts.LaptopService;
import com.example.product_microservice.dataAccess.LaptopRepository;
import com.example.product_microservice.dto.ProductDetailResponse;
import com.example.product_microservice.entity.Laptop;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class LaptopManager implements  LaptopService {
    
    @Autowired
    private LaptopRepository laptopRepository;
    @Override
    public ProductDetailResponse getLaptopDetail(int productId, int id) {
        Laptop laptop = laptopRepository.findFirstByProductIdAndId(productId, id);
        ProductDetailResponse productDetailResponse = new ProductDetailResponse();
        productDetailResponse.setId(laptop.getId());
        productDetailResponse.setProduct_id(laptop.getProduct().getId());
        String size = laptop.getMemorySize().getSize()+"GB";
         if("1000".equals(laptop.getMemorySize().getSize())){
            size = "1TB";
        }
        String name =laptop.getProduct().getName()+ " " +size + " " + laptop.getRam_capacity();
        productDetailResponse.setName(name);
        productDetailResponse.setImageurl(laptop.getProduct().getImageUrl());
        productDetailResponse.setDescription(laptop.getProduct().getDescription());
        productDetailResponse.setPrice(laptop.getPrice());
        return  productDetailResponse;

    }

}
