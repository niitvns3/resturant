package com.resturent.restaurant.restcontrollertest;

import com.resturent.restaurant.repository.RestaurantRepository;
import com.resturent.restaurant.service.RestaurantRepositoryService;
import com.resturent.restaurant.model.Restaurant;
import com.resturent.restaurant.enumtype.PriceRangeType;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RestaurantControllerTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantRepositoryService restaurantRepositoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetEndpoint() {
        // Arrange: prepare mock data
        Restaurant r1 = new Restaurant();
        r1.setId(1L);
        r1.setAddress("Delhi");
        r1.setPricerange(PriceRangeType.HIGH);
        r1.setName("Pizza Hut");
        r1.setCuisineType("Italian");

        Restaurant r2 = new Restaurant();
        r2.setId(17L);
        r1.setAddress("Delhi");
        r2.setPricerange(PriceRangeType.HIGH);
        r2.setName("Domino");
        r2.setCuisineType("Italian");

        // Mock repository
        when(restaurantRepository.findAll()).thenReturn(Arrays.asList(r1,r2));

        // Act: call the service method
        List<Restaurant> result = restaurantRepositoryService.getAllRestaurant();

        // Print result (this now prints BOTH restaurants correctly)
        System.out.println("-------- Retrieved Restaurants --------");
        for (Restaurant r : result) {
            System.out.println("Restaurant ID: " + r.getId());
            System.out.println("Name        : " + r.getName());
            System.out.println("Address     : " + r.getAddress());
            System.out.println("Cuisine     : " + r.getCuisineType());
            System.out.println("Price Range : " + r.getPricerange());
            System.out.println("--------------------------------------");
        }

        // Assert: verify correct results
        assertEquals(2, result.size());
        assertEquals("Pizza Hut", result.get(0).getName());
        assertEquals("Domino", result.get(1).getName());

        System.out.println(result);
    }

@Test
public void testPostSaveRestaurant() {
    // Arrange: create a new Restaurant object
    Restaurant r1 = new Restaurant();

    r1.setAddress("Mumbai");
    r1.setPricerange(PriceRangeType.HIGH);
    r1.setName("Pizza Hut");
    r1.setCuisineType("Italian");

    // Mock the save behavior — return the same object
    when(restaurantRepository.save(any(Restaurant.class))).thenReturn(r1);

    // Act: call your service save method (you may need to create it if not already)
    Restaurant savedRestaurant = restaurantRepositoryService.saveDataRestaurant(r1);

    // Assert: check the saved values
    assertNotNull(savedRestaurant);
    assertEquals("Pizza Hut", savedRestaurant.getName());
    assertEquals("Mumbai", savedRestaurant.getAddress());

    // Print for visual confirmation
    System.out.println("-------- Saved Restaurant --------");
    System.out.println("ID         : " + savedRestaurant.getId());
    System.out.println("Name       : " + savedRestaurant.getName());
    System.out.println("Address    : " + savedRestaurant.getAddress());
    System.out.println("Cuisine    : " + savedRestaurant.getCuisineType());
    System.out.println("Price Range: " + savedRestaurant.getPricerange());
    System.out.println("----------------------------------");

    System.out.println("✅ Save Data in repo mock DB ✅");
}


}
