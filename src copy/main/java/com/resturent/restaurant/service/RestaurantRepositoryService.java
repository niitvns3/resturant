
package com.resturent.restaurant.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.resturent.restaurant.repository.RestaurantRepository;
import com.resturent.restaurant.model.Restaurant;
import java.util.*;

@Service
public class RestaurantRepositoryService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional  // 👈 holds transaction until method completes
    public  Restaurant  saveDataRestaurant(Restaurant data)  {
       
       return  restaurantRepository.save(data);
 
    }


    @Transactional  // 👈 holds transaction until method completes
    public  List <Restaurant>  getAllRestaurant()  {
        List <Restaurant> list = new ArrayList<>();
        list = restaurantRepository.findAll();
        return list;
    }

}