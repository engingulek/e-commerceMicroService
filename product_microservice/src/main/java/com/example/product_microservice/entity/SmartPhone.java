package com.example.product_microservice.entity;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name= "smart_phones")
@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmartPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id; 
    @Column(name = "price",precision = 3, scale = 2)
    private BigDecimal price;
    /*@Column(name = "color_id")
    private int color_id;*/
    /*@Column(name = "memory_size_id")
    private int memory_size_id;*/
    @Column(name = "battery_capacity")
    private String battery_capacity;
    @Column(name = "ram_capacity")
    private int ram_capacity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "memory_size_id")
    private MemorySize memorySize;

   @OneToOne
   @JoinColumn(name="color_id")
   private Color color;

 

 

    
}
