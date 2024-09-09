package com.example.product_microservice.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_microservice.business.abstracts.SmartPhoneService;
import com.example.product_microservice.dataAccess.SmartPhoneRepository;
import com.example.product_microservice.dto.smartPhone.GetSmartPhoneDetailResponse;
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
    public GetSmartPhoneDetailResponse getSmartPhoneDetail(int productId,int id) {
        SmartPhone smartPhone =  smartPhoneRepository.findFirstByProductIdAndId(productId, id);
        GetSmartPhoneDetailResponse getSmartPhoneDetailResponse = new GetSmartPhoneDetailResponse();
        

        getSmartPhoneDetailResponse.setId(smartPhone.getId());
        getSmartPhoneDetailResponse.setProduct_id(smartPhone.getProduct().getId());
        String size = smartPhone.getMemorySize().getSize()+"GB";
         if("1000".equals(smartPhone.getMemorySize().getSize())){
            size = "1TB";
        }
        String name =smartPhone.getProduct().getName()+ " " +size + " " + smartPhone.getColor().getName();
        getSmartPhoneDetailResponse.setName(name);
        getSmartPhoneDetailResponse.setImageurl(smartPhone.getProduct().getImageUrl());
        getSmartPhoneDetailResponse.setDescription(smartPhone.getProduct().getDescription());
        getSmartPhoneDetailResponse.setPrice(smartPhone.getPrice());
        getSmartPhoneDetailResponse.setColor_id(smartPhone.getColor().getId());
        getSmartPhoneDetailResponse.setMemory_size_id(smartPhone.getMemorySize().getId());
       
        
        return  getSmartPhoneDetailResponse;
    }
}
