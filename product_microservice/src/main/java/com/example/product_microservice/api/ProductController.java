package com.example.product_microservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_microservice.business.abstracts.ProductService;
import com.example.product_microservice.business.abstracts.SmartPhoneService;
import com.example.product_microservice.dto.GetBaseProductResponse;
import com.example.product_microservice.dto.GetSmartPhoneDetailResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/product")
@AllArgsConstructor
@NoArgsConstructor
public class ProductController {
     @Autowired
    private ProductService productService;
    @Autowired 
    private SmartPhoneService smartPhoneService;

    @GetMapping("/getAll")
    public List<GetBaseProductResponse> getAll() {
        return  productService.getAll();
    }
    @GetMapping("/getSmartPhones")
    public List<GetBaseProductResponse> getSmartPhonesBaseResponse(){
        return  productService.getSmartPhonesBaseResponse();
    }

    @GetMapping("/getLaptops")
    public List<GetBaseProductResponse> getLaptops(){
        return  productService.getLaptops();
    }

    @GetMapping("/getSmartPhoneDetail")
    public GetSmartPhoneDetailResponse getSmartPhoneDetail(@RequestParam int id , @RequestParam int product_id){
        return  smartPhoneService.getSmartPhoneDetail(product_id, id);
    }

    
}
