package com.resturent.restaurant.model;
import com.resturent.restaurant.enumtype.PriceRangeType;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
 // It's best practice to use lowercase table names
public class Restaurant {


  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto-increment in H2
 	@ Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

     @Column(name = "cuisineType")
    private String cuisineType;


     @Column(name = "address")
    private String address;

    @Enumerated(EnumType.STRING) 
    private PriceRangeType pricerange; // You can convert this to an enum later if needed
   
    
     public Restaurant(String name, String cuisineType, String address, PriceRangeType pricerange) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.address = address;
        this.pricerange = pricerange;
    }


}