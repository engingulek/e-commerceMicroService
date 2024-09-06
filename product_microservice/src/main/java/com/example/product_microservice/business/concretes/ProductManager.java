package com.example.product_microservice.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_microservice.business.abstracts.ProductService;
import com.example.product_microservice.core.mapper.ModelMapperService;
import com.example.product_microservice.dataAccess.ProductRepository;
import com.example.product_microservice.dto.GetBaseProductResponse;
import com.example.product_microservice.dto.GetSmartPhoneResponse;
import com.example.product_microservice.entity.Product;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductManager implements  ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapperService modelMapperService;
   

    @Override
    public List<GetBaseProductResponse<GetSmartPhoneResponse>> getSmartPhonesBaseResponse() {
        List<Product> products = productRepository.findBySubCategoryId(1);




        return products.stream().map(product -> {
            
            @SuppressWarnings("unchecked")
            GetBaseProductResponse<GetSmartPhoneResponse> getBaseProductResponse = modelMapperService
            .forResponse().map(product, GetBaseProductResponse.class);

            // SubCategory -> GetSubCategoryResponse dönüşümü (getter olmadan)
            List<GetSmartPhoneResponse> getSmartPhoneResponses = product.getSubProducts().stream()
                    .map(subCategory -> modelMapperService.forResponse().map(subCategory, GetSmartPhoneResponse.class))
                    .collect(Collectors.toList());
                    

                    getBaseProductResponse.setSubProducts(getSmartPhoneResponses);

            return getBaseProductResponse;
        }).collect(Collectors.toList());
    }

}
