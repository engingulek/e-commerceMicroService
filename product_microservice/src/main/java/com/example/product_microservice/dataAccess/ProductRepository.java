package com.example.product_microservice.dataAccess;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_microservice.entity.Product;
public interface  ProductRepository extends JpaRepository<Product, Integer>{


/*@Query("SELECT new com.example.product_microservice.dto.GetBaseProductResponse(p.id ,s.id , p.imageUrl,p.name,s.price) FROM Product as p JOIN SmartPhone as s ON p.id = s.product_id  GROUP BY p.id, s.id, p.imageUrl, p.name, s.price")
List<GetBaseProductResponse> getSmartPhonesBaseResponse();*/

List<Product> findBySubCategoryId(int sub_category_id);



}