package com.example.product_microservice.business.concretes;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_microservice.business.abstracts.ProductService;
import com.example.product_microservice.core.mapper.ModelMapperService;
import com.example.product_microservice.dataAccess.ProductRepository;
import com.example.product_microservice.dto.GetClothesDto;
import com.example.product_microservice.dto.baseProduct.GetBaseProductResponse;
import com.example.product_microservice.dto.baseProduct.generics.GetBaseProductResForClothes;
import com.example.product_microservice.dto.baseProduct.generics.GetBaseProductResForElec;
import com.example.product_microservice.dto.laptop.GetLaptopResponse;
import com.example.product_microservice.dto.smartPhone.GetSmartPhonesResponse;
import com.example.product_microservice.entity.Color;
import com.example.product_microservice.entity.MemorySize;
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

        List<GetBaseProductResponse> list = products.stream().flatMap(product -> {
           
            GetBaseProductResponse getBaseProductResponse = modelMapperService
            .forResponse().map(product, GetBaseProductResponse.class);

            return product.getSmartPhones().stream().map(subProduct -> {

                GetBaseProductResForElec<MemorySize,Color> newResponse = new GetBaseProductResForElec<>();
                newResponse.setId(getBaseProductResponse.getId());
                newResponse.setImageurl(getBaseProductResponse.getImageurl());
               

                GetSmartPhonesResponse getSubProductResponse = modelMapperService.forResponse()
                .map(subProduct, GetSmartPhonesResponse.class);
                newResponse.setPrice(getSubProductResponse.getPrice());
                newResponse.setFeature_one(getSubProductResponse.getMemorySize());
                newResponse.setFeature_tow(getSubProductResponse.getColor());

                
                String size = getSubProductResponse.getMemorySize().getSize()+"GB";
                if("1000".equals(getSubProductResponse.getMemorySize().getSize())){
                    size = "1TB";
                }
                String name =getBaseProductResponse.getName() + " " +size + " " + getSubProductResponse.getColor().getName();
                newResponse.setName(name);
                

                return newResponse;
            });
        }).collect(Collectors.toList());

        return  list;
    }


   @Override
    public List<GetBaseProductResponse> getLaptops() {
        List<Product> products = productRepository.findBySubCategoryId(2);
        
        List<GetBaseProductResponse> list = products.stream().flatMap(product -> {
            
            GetBaseProductResponse getBaseProductResponse = modelMapperService
            .forResponse().map(product, GetBaseProductResponse.class);

            return product.getLaptops().stream().map(subProduct -> {

                GetBaseProductResForElec<MemorySize,Integer> newResponse = new GetBaseProductResForElec<>();
                newResponse.setId(getBaseProductResponse.getId());
                newResponse.setImageurl(getBaseProductResponse.getImageurl());
                

                GetLaptopResponse getLaptopResponse = modelMapperService.forResponse()
                .map(subProduct, GetLaptopResponse.class);
                newResponse.setPrice(getLaptopResponse.getPrice());
                String size = getLaptopResponse.getMemorySize().getSize()+"GB";
                if("1000".equals(getLaptopResponse.getMemorySize().getSize())){
                    size = "1TB";
                }
                String name = getBaseProductResponse.getName()+
                " "+ size + " "+ 
                getLaptopResponse.getRam_capacity()+"RAM " + 
                getLaptopResponse.getOperating_system();
                newResponse.setName(name);
                newResponse.setFeature_one(getLaptopResponse.getMemorySize());
                
                newResponse.setFeature_tow(getLaptopResponse.getRam_capacity());
               
                return newResponse;
            });
        }).collect(Collectors.toList());    

        return  list;
    }



@Override
public List<GetBaseProductResponse> getElecAll() {
    List<GetBaseProductResponse> smartPhoneList = getSmartPhonesBaseResponse();
    List<GetBaseProductResponse> laptops = getLaptops();
    


    List<GetBaseProductResponse> allProduct = Stream.concat(smartPhoneList.stream(), laptops.stream())
                                          .collect(Collectors.toList());
 
    return  allProduct;
}


@Override
public List<GetBaseProductResponse> getThirsts() {
    List<GetClothesDto> products = productRepository.findBySubCategoryIdForClothes(6);

    List<GetBaseProductResponse> list = products.stream().map(a -> this.modelMapperService.forResponse()
        .map(a, GetBaseProductResForClothes.class)).collect(Collectors.toList());

    return  list;
}


@Override
public List<GetBaseProductResponse> getJumpers() {
    List<GetClothesDto> products = productRepository.findBySubCategoryIdForClothes(4);
    List<GetBaseProductResponse> list = products.stream().map(a -> this.modelMapperService.forResponse()
    .map(a, GetBaseProductResForClothes.class)).collect(Collectors.toList());
    return  list;
}


@Override
public List<GetBaseProductResponse> getClothesAll() {
    
    List<GetBaseProductResponse> tshirtList = getThirsts();
    List<GetBaseProductResponse> jumperList = getJumpers();
    


    List<GetBaseProductResponse> allProduct = Stream.concat(tshirtList.stream(), jumperList.stream())
                                          .collect(Collectors.toList());
 
    return  allProduct;
}





}
