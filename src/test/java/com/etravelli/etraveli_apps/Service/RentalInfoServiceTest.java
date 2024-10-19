package com.etravelli.etraveli_apps.Service;

import com.etravelli.etraveli_apps.model.Customer;
import com.etravelli.etraveli_apps.model.Movie;
import com.etravelli.etraveli_apps.model.Rent;
import com.etravelli.etraveli_apps.model.RentInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest  // Loads the Spring ApplicationContext
@ComponentScan(basePackages = "com.etravelli.etraveli_apps.Service")
public class RentalInfoServiceTest {

    @Autowired
    private RentalInfoService rentalInfoService;

    private List<Movie> movies;
    private RentInfo rentInfo;
    private  Customer customer;

    //Rent rent;

    @BeforeEach
    public void setup() {
        rentalInfoService = new RentalInfoService();
        movies = new ArrayList<>();

        customer=new Customer("Sachin","Pune");

        // Add different movie types
        movies.add( new Movie("Inception", new NewReleaseMovie(),4));
        movies.add(new Movie("Frozen", new ChildrensMovie(),5));
        movies.add(new Movie("Titanic", new RegularMovie(),6));

        rentInfo=new RentInfo(customer,movies);

    }

    @Test
    public void testSingleNewReleaseMovieMoreThan2Days() {

        Rent rent = rentalInfoService.processRent(rentInfo);

        assertEquals("24.5", rent.getTotalAmout());  // 3 * 3 = 9.0
        assertEquals("4", rent.getUserPoints());    // 1 base + 1 bonus point
    }

    @Test
    public void testSingleChildrenMovieFor2Days() {

        Rent rent = rentalInfoService.processRent(rentInfo);

        assertEquals("1.5", rent.getTotalAmout());  // Fixed children movie cost
        assertEquals("1", rent.getUserPoints());    // Only 1 base point, no bonus
    }

    @Test
    public void testMultipleMovies() {
        /*Customer customer = new Customer("Alice", List.of(
                new MovieRental("1", 1),  // New release for 1 day
                new MovieRental("3", 5)   // Regular movie for 5 days
        ));*/

        Rent rent = rentalInfoService.processRent(rentInfo);

        assertEquals("11.5", rent.getTotalAmout());  // 3 + (2 + 1.5*3) = 11.5
        assertEquals("2", rent.getUserPoints());    // 2 points (1 per movie)
    }

    @Test
    public void testNoRentals() {
        //Customer customer = new Customer("Bob", List.of());  // No rentals

        Rent rent = rentalInfoService.processRent(rentInfo);

        assertEquals("0.0", rent.getTotalAmout());
        assertEquals("0", rent.getUserPoints());
    }

    @Test
    public void testInvalidMovieId() {
//        Customer customer = new Customer("Charlie", List.of(
//                new MovieRental("999", 3)  // Invalid movie ID
//        ));

        Exception exception = assertThrows(NullPointerException.class, () ->
                rentalInfoService.processRent(rentInfo)
        );

        assertTrue(exception.getMessage().contains("null"));  // Expected exception
    }
}
