package com.etravelli.etraveli_apps.model;

import com.etravelli.etraveli_apps.Interface.MovieType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Movie {
    private String title;
    private MovieType movieType;
    private int rentDays;


    public double calculateAmount(int daysRented) {
        return movieType.calculateAmount(daysRented);
    }

}
