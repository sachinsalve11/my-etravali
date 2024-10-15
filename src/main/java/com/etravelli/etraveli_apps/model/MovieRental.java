package com.etravelli.etraveli_apps.model;


import org.springframework.stereotype.Component;

@Component
public class MovieRental {



    private String movieId;
    private int days;

    public MovieRental(String movieId, int days) {
        this.movieId = movieId;
        this.days = days;
    }
    public String getMovieId() {
        return movieId;
    }

    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}