package com.etravelli.etraveli_apps.Interface;

import com.etravelli.etraveli_apps.model.Customer;
import com.etravelli.etraveli_apps.model.Movie;
import com.etravelli.etraveli_apps.model.Rent;

import java.util.HashMap;

public interface RentalInfoInterface {

    public String processRent();

    Rent processRent(Customer customer, HashMap<String, Movie> movies);
    public String processStatement(Rent rent);
}
