package com.etravelli.etraveli_apps;

import com.etravelli.etraveli_apps.Interface.MovieInterface;
import com.etravelli.etraveli_apps.Interface.RentalInfoInterface;
import com.etravelli.etraveli_apps.model.Customer;
import com.etravelli.etraveli_apps.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    RentalInfoInterface rentalInfoInterface;

    @Autowired
    MovieInterface movieInterface;

    @Autowired
    Customer customer;

    @GetMapping("/")
    public void getMovieRentInfo(){
        Rent rent=rentalInfoInterface.processRent(customer,movieInterface.getMovies());
        rentalInfoInterface.processStatement(rent);


    }

}
