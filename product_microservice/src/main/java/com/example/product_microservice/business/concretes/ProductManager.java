package com.example.product_microservice.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_microservice.business.abstracts.ProductService;
import com.example.product_microservice.core.mapper.ModelMapperService;
import com.example.product_microservice.dataAccess.ProductRepository;
import com.example.product_microservice.dto.GetBaseProductResponse;
import com.example.product_microservice.dto.GetSubProductResponse;
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
    public List<GetBaseProductResponse> getSmartPhonesBaseResponse() {

        List<Product> products = productRepository.findBySubCategoryId(1);

        return products.stream().flatMap(product -> {
             GetBaseProductResponse getBaseProductResponse = modelMapperService
            .forResponse().map(product, GetBaseProductResponse.class);

            return product.getSmartPhones().stream().map(subProduct -> {

                GetBaseProductResponse newResponse = new GetBaseProductResponse();
                newResponse.setId(getBaseProductResponse.getId());
                newResponse.setImageurl(getBaseProductResponse.getImageurl());
                newResponse.setName(getBaseProductResponse.getName());

                GetSubProductResponse getSubProductResponse = modelMapperService.forResponse()
                .map(subProduct, GetSubProductResponse.class);
                newResponse.setPrice(getSubProductResponse.getPrice());
                newResponse.setSub_product_id(getSubProductResponse.getId());
                return newResponse;
            });
        }).collect(Collectors.toList());
    }


   @Override
    public List<GetBaseProductResponse> getLaptops() {
        List<Product> products = productRepository.findBySubCategoryId(2);
        
        return products.stream().flatMap(product -> {
             GetBaseProductResponse getBaseProductResponse = modelMapperService
            .forResponse().map(product, GetBaseProductResponse.class);

            return product.getLaptops().stream().map(subProduct -> {

                GetBaseProductResponse newResponse = new GetBaseProductResponse();
                newResponse.setId(getBaseProductResponse.getId());
                newResponse.setImageurl(getBaseProductResponse.getImageurl());
                newResponse.setName(getBaseProductResponse.getName());

                GetSubProductResponse getSubProductResponse = modelMapperService.forResponse()
                .map(subProduct, GetSubProductResponse.class);
                newResponse.setPrice(getSubProductResponse.getPrice());
                newResponse.setSub_product_id(getSubProductResponse.getId());
                return newResponse;
            });
        }).collect(Collectors.toList());      
    }


}
