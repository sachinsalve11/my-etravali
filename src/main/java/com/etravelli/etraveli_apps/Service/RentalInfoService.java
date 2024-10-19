package com.etravelli.etraveli_apps.Service;

import com.etravelli.etraveli_apps.Interface.RentalInfoInterface;
import com.etravelli.etraveli_apps.model.Movie;
import com.etravelli.etraveli_apps.model.Rent;
import com.etravelli.etraveli_apps.model.RentInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RentalInfoService implements RentalInfoInterface {


    private Rent rent=new Rent();

    public String processStatement(Rent rent) {
        log.info("Amount owed is " + rent.getTotalAmout() + "\n");
        log.info("You earned " + rent.getUserPoints() + " frequent points\n");
        return rent.toString();
    }

    @Override
    public Rent processRent(RentInfo rentInfo) {
        double totalAmount = 0;
        int frequentEnterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + rentInfo.getCustomer().getName() + "\n");

        for (Movie movie : rentInfo.getMovieList()) {

            double thisAmount = movie.calculateAmount(movie.getRentDays());

            // Add basic point and any bonus points based on movie type
            frequentEnterPoints++;  // 1 point for every rental
            frequentEnterPoints += movie.getMovieType().getBonusPoints(movie.getRentDays());

            // Append rental details
            result.append("\t").append(movie.getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }

        rent.setTotalAmout(String.valueOf(totalAmount));
        rent.setUserPoints(String.valueOf(frequentEnterPoints));
        return rent;
    }

}
