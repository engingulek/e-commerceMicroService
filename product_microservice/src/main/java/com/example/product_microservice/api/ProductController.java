package com.example.product_microservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_microservice.business.abstracts.LaptopService;
import com.example.product_microservice.business.abstracts.ProductService;
import com.example.product_microservice.business.abstracts.SmartPhoneService;
import com.example.product_microservice.core.results.Result;
import com.example.product_microservice.core.results.SuccessDataResult;

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

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/getSmartPhones")
    public ResponseEntity<Result> getSmartPhonesBaseResponse(){
        return  ResponseEntity
        .ok(new SuccessDataResult<>(
            productService.getSmartPhonesBaseResponse(),
            true, "fetch successful")) ;
        
    }

    @GetMapping("/getLaptops")
    public ResponseEntity<Result> getLaptops(){
        return  ResponseEntity.ok(new SuccessDataResult<>(
            productService.getLaptops(),
            true, "fetch successful")) ;
        
    }

    @GetMapping("/getThirsts")
    public ResponseEntity<Result> getThirsts(){
        return  ResponseEntity.ok(
            new SuccessDataResult<>(
            productService.getThirsts() ,true, "fetchSuccess ful"));
    }

    @GetMapping("/getJumpers")
    public ResponseEntity<Result> getJumpers(){
        return  ResponseEntity.ok(
            new SuccessDataResult<>(
            productService.getJumpers() ,true, "fetchSuccess ful"));
    }

    @GetMapping("/getSmartPhoneDetail")
    public ResponseEntity<Result> getSmartPhoneDetail(@RequestParam int id , @RequestParam int product_id){
        return smartPhoneService.getSmartPhoneDetail(product_id, id);
    }

    @GetMapping("/getLaptopDetail")
    public ResponseEntity<Result> getLaptopDetail(@RequestParam int id , @RequestParam int product_id){
        return laptopService.getLaptopDetail(product_id, id);
    }

    @GetMapping("/searchProduct")
    public ResponseEntity<Result> searchProduct(@RequestParam String searchText){
        return  ResponseEntity
        .ok(new SuccessDataResult<>(
            productService.searchText(searchText),
            true, "fetch successful")) ;
    }

    
}
