package com.example.product_microservice.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_microservice.business.abstracts.ProductService;
import com.example.product_microservice.core.mapper.ModelMapperService;
import com.example.product_microservice.dataAccess.ColorRepository;
import com.example.product_microservice.dataAccess.MemorySizeRepository;
import com.example.product_microservice.dataAccess.ProductRepository;
import com.example.product_microservice.dto.clothes.GetClothesDto;
import com.example.product_microservice.entity.Color;
import com.example.product_microservice.entity.MemorySize;
import com.example.product_microservice.entity.Product;
import com.example.product_microservice.response.base.GetBaseFeatureResponse;
import com.example.product_microservice.response.base.GetBaseProductResponse;
import com.example.product_microservice.response.laptop.GetLaptopResponse;
import com.example.product_microservice.response.smartPhone.GetSmartPhonesResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductManager implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    @Autowired 
    private MemorySizeRepository memorySizeRepository;

    @Autowired
    private ColorRepository colorRepository;

    // MARK: GetSmartPhonesBaseResponse
    @Override
    public List<GetBaseProductResponse> getSmartPhonesBaseResponse() {

        List<Product> products = productRepository.findBySubCategoryId(1);

        List<GetBaseProductResponse> list = products.stream().flatMap(product -> {

            GetBaseProductResponse getBaseProductResponse = modelMapperService
                    .forResponse().map(product, GetBaseProductResponse.class);

            return product.getSmartPhones().stream().map(subProduct -> {

                GetBaseProductResponse newResponse = new GetBaseProductResponse();
                newResponse.setId(getBaseProductResponse.getId());
                newResponse.setImageurl(getBaseProductResponse.getImageurl());
                newResponse.setProduct_id(subProduct.getId());
                GetSmartPhonesResponse getSubProductResponse = modelMapperService.forResponse()
                        .map(subProduct, GetSmartPhonesResponse.class);
                newResponse.setPrice(getSubProductResponse.getPrice());
                
                String size = getSubProductResponse.getMemorySize().getSize() + "GB";
                if ("1000".equals(getSubProductResponse.getMemorySize().getSize())) {
                    size = "1TB";
                }
                String name = getBaseProductResponse.getName() + " " + size + " "
                        + getSubProductResponse.getColor().getName();
                newResponse.setName(name);

                return newResponse;
            });
        }).collect(Collectors.toList());

        return list;
    }

    // MARK: getLaptops
    @Override
    public List<GetBaseProductResponse> getLaptops() {
        List<Product> products = productRepository.findBySubCategoryId(2);

        List<GetBaseProductResponse> list = products.stream().flatMap(product -> {

            GetBaseProductResponse getBaseProductResponse = modelMapperService
                    .forResponse().map(product, GetBaseProductResponse.class);

            return product.getLaptops().stream().map(subProduct -> {

                GetBaseProductResponse newResponse = new GetBaseProductResponse();
                newResponse.setId(getBaseProductResponse.getId());
                newResponse.setImageurl(getBaseProductResponse.getImageurl());
                newResponse.setProduct_id(subProduct.getId());
                GetLaptopResponse getLaptopResponse = modelMapperService.forResponse()
                        .map(subProduct, GetLaptopResponse.class);
                newResponse.setPrice(getLaptopResponse.getPrice());
                String size = getLaptopResponse.getMemorySize().getSize() + "GB";
                if ("1000".equals(getLaptopResponse.getMemorySize().getSize())) {
                    size = "1TB";
                }
                String name = getBaseProductResponse.getName() +
                        " " + size + " " +
                        getLaptopResponse.getRam_capacity() + "RAM " +
                        getLaptopResponse.getOperating_system();
                newResponse.setName(name);

                return newResponse;
            });
        }).collect(Collectors.toList());

        return list;
    }


    // MARK: getThirsts
    @Override
    public List<GetBaseProductResponse> getThirsts() {
        List<GetClothesDto> products = productRepository.findBySubCategoryIdForClothes(6);

        List<GetBaseProductResponse> list = products.stream()
                .map(a -> this.modelMapperService.forResponse()
                        .map(a, GetBaseProductResponse.class))
                .collect(Collectors.toList());

        return list;
    }

    // MARK: getJumpers
    @Override
    public List<GetBaseProductResponse> getJumpers() {
        List<GetClothesDto> products = productRepository.findBySubCategoryIdForClothes(4);
        List<GetBaseProductResponse> list = products.stream()
                .map(a -> this.modelMapperService.forResponse()
                        .map(a, GetBaseProductResponse.class))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public List<MemorySize> getAllMemorySize() {
        List<MemorySize> memorySizes = memorySizeRepository.findAll();
       
      
        return memorySizes;
    }

    @Override
    public List<GetBaseFeatureResponse> getAllColor() {
        List<Color> colors = colorRepository.findAll();
        List<GetBaseFeatureResponse> list = colors.stream()
        .map(a-> this.modelMapperService.forResponse()
        .map(a, GetBaseFeatureResponse.class))
        .collect(Collectors.toList());
        return list;
    }



}
