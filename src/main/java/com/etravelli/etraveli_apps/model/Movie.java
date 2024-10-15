package com.etravelli.etraveli_apps.model;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Movie {


    private String title;

    private String code;

    public Movie(String title, String code) {

        this.title = title;
        this.code = code;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(code, movie.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, code);
    }
}