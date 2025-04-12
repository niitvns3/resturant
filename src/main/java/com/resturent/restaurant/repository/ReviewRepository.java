package com.resturent.restaurant.repository;

import com.resturent.restaurant.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // You can define custom queries here if needed
}
