package com.example.product_microservice.dataAccess;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.product_microservice.entity.Product;
public interface  ProductRepository extends JpaRepository<Product, Integer>{


/*@Query("SELECT new com.example.product_microservice.dto.GetBaseProductResponse(p.id ,s.id , p.imageUrl,p.name,s.price) FROM Product as p JOIN SmartPhone as s ON p.id = s.product_id  GROUP BY p.id, s.id, p.imageUrl, p.name, s.price")
List<GetBaseProductResponse> getSmartPhonesBaseResponse();*/

List<Product> findBySubCategoryId(int sub_category_id);

//Product findByIdAndSubProductId(int id,int sub_category_id);
@Query(value = "SELECT p.id,p.name FROM products p JOIN smart_phones s on s.product_id = p.id WHERE s.product_id = :sub_product_id AND s.id = :id group by  p.id,p.name Limit 1", nativeQuery=true)
List<Product> findSmartPhoneDetail(@Param("id") int id,@Param("sub_product_id") int sub_product_id);






}