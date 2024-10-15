package com.etravelli.etraveli_apps.model;


import lombok.Data;

@Data
public class Rent {
    public String totalAmout;

    @Override
    public String toString() {
        return "Rent{" +
                "totalAmout='" + totalAmout + '\'' +
                ", userPoints='" + userPoints + '\'' +
                '}';
    }

    public String userPoints;
}
