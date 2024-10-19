package com.etravelli.etraveli_apps.Interface;

import com.etravelli.etraveli_apps.model.Customer;
import com.etravelli.etraveli_apps.model.Movie;
import com.etravelli.etraveli_apps.model.Rent;
import com.etravelli.etraveli_apps.model.RentInfo;

import java.util.HashMap;

public interface RentalInfoInterface {

    Rent processRent(RentInfo rentInfo);
    public String processStatement(Rent rent);
}
