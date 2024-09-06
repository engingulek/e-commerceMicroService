package com.example.product_microservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_microservice.business.abstracts.ProductService;
import com.example.product_microservice.dto.GetBaseProductResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/product")
@AllArgsConstructor
@NoArgsConstructor
public class ProductController {
     @Autowired
    private ProductService productService;

    @GetMapping("/getSmartPhones")
    public List<GetBaseProductResponse> getSmartPhonesBaseResponse(){
        return  productService.getSmartPhonesBaseResponse();
    }

    @GetMapping("/getLaptops")
    public List<GetBaseProductResponse> getLaptops(){
        return  productService.getLaptops();
    }
}
