package com.etravelli.etraveli_apps.Service;

import com.etravelli.etraveli_apps.Interface.RentalInfoInterface;
import com.etravelli.etraveli_apps.model.Customer;
import com.etravelli.etraveli_apps.model.Movie;
import com.etravelli.etraveli_apps.model.MovieRental;
import com.etravelli.etraveli_apps.model.Rent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class RentalInfoService implements RentalInfoInterface {

    @Autowired
    Rent rent;

    public String processStatement(Rent rent) {

        log.info( "Amount owed is " + rent.getTotalAmout() + "\n");
        log.info("You earned " + rent.getUserPoints() + " frequent points\n");
        return rent.toString();
    }

    @Override
    public String processRent() {
        return "";
    }

    @Override
    public Rent processRent(Customer customer, HashMap<String, Movie> movies) {
        double totalAmount = 0;
        int frequentEnterPoints = 0;
        String result = "Rental Record for " + customer.getName() + "\n";
        for (MovieRental r : customer.getRentals()) {
            double thisAmount = 0;

            // determine amount for each movie
            if (movies.get(r.getMovieId()).getCode().equals("regular")) {
                thisAmount = 2;
                if (r.getDays() > 2) {
                    thisAmount = ((r.getDays() - 2) * 1.5) + thisAmount;
                }
            } else if (movies.get(r.getMovieId()).getCode().equals("new")) {
                thisAmount = r.getDays() * 3;
            }else if(movies.get(r.getMovieId()).getCode().equals("childrens")) {
                thisAmount = 1.5;
                if (r.getDays() > 3) {
                    thisAmount = ((r.getDays() - 3) * 1.5) + thisAmount;
                }
            }

            //add frequent bonus points
            frequentEnterPoints++;
            // add bonus for a two day new release rental
            if (movies.get(r.getMovieId()).getCode() == "new" && r.getDays() > 2) frequentEnterPoints++;

            //print figures for this rental
            result += "\t" + movies.get(r.getMovieId()).getTitle() + "\t" + thisAmount + "\n";
            totalAmount = totalAmount + thisAmount;
        }
        rent.setTotalAmout(String.valueOf(totalAmount));
        rent.setUserPoints(String.valueOf(frequentEnterPoints));
        return rent;
    }


}
