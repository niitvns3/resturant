package com.resturent.restaurant.restcontroller;

import com.resturent.restaurant.model.Restaurant;
import com.resturent.restaurant.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.resturent.restaurant.service.RestaurantRepositoryService;
import com.resturent.restaurant.service.ReviewRepositoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController
{
    @Autowired
    private RestaurantRepositoryService restaurantRepositoryService;
    
    @Autowired
    private ReviewRepositoryService reviewRepositoryService;
    

    @PostMapping("/saveRestaurant")
    public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
      return  restaurantRepositoryService.saveDataRestaurant(restaurant);
        
    }


    @GetMapping("/allrestaurant")
    public List<Restaurant>  getRestaurant() {  
        return  restaurantRepositoryService.getAllRestaurant();
    }




    @PostMapping("/saveReview")
    public Review saveReview(@RequestBody Review Review) {
      return  reviewRepositoryService.saveDataReview(Review);
        
    }


    @GetMapping("/allReview")
    public List<Review>  getReview() {  
        return  reviewRepositoryService.getAllReview();
    }


    
    public List<Review>  getReviewMoc() {  
        return  reviewRepositoryService.getAllReview();
    }


}
