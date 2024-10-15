package com.etravelli.etraveli_apps.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Customer {

    private String name;
    private List<MovieRental> rentals;

    public Customer(String name, List<MovieRental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setRentals(List<MovieRental> movieRentals){
        this.rentals=movieRentals;
    }

    public String getName() {
        return name;
    }

    public List<MovieRental> getRentals() {
        return rentals;
    }
}