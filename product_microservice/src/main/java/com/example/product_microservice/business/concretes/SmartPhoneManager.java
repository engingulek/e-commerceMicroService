package com.example.product_microservice.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_microservice.business.abstracts.SmartPhoneService;
import com.example.product_microservice.dataAccess.SmartPhoneRepository;
import com.example.product_microservice.dto.ProductDetailResponse;
import com.example.product_microservice.entity.SmartPhone;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SmartPhoneManager implements SmartPhoneService {
    @Autowired
    private SmartPhoneRepository smartPhoneRepository;

    @Override
    public ProductDetailResponse getSmartPhoneDetail(int productId,int id) {
        SmartPhone smartPhone =  smartPhoneRepository.findFirstByProductIdAndId(productId, id);
        ProductDetailResponse productDetailResponse = new ProductDetailResponse();
        productDetailResponse.setId(smartPhone.getId());
        productDetailResponse.setProduct_id(smartPhone.getProduct().getId());
        String size = smartPhone.getMemorySize().getSize()+"GB";
         if("1000".equals(smartPhone.getMemorySize().getSize())){
            size = "1TB";
        }
        String name =smartPhone.getProduct().getName()+ " " +size + " " + smartPhone.getColor().getName();
        productDetailResponse.setName(name);
        productDetailResponse.setImageurl(smartPhone.getProduct().getImageUrl());
        productDetailResponse.setDescription(smartPhone.getProduct().getDescription());
        productDetailResponse.setPrice(smartPhone.getPrice());
       
        
        return  productDetailResponse;
    }
}
