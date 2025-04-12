package com.resturent.restaurant.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.resturent.restaurant.repository.ReviewRepository;
import com.resturent.restaurant.model.Review;
import java.util.*;


@Service
public class ReviewRepositoryService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional  // 👈 holds transaction until method completes
    public  Review  saveDataReview(Review data)  {
              return  reviewRepository.save(data);
 
    }


    @Transactional  // 👈 holds transaction until method completes
    public  List <Review>  getAllReview()  {
        List <Review> list = new ArrayList<>();
        list = reviewRepository.findAll();
        return list;
    }

}