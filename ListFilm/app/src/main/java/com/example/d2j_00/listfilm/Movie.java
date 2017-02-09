package com.example.d2j_00.listfilm;

import java.io.Serializable;

/**
 * Created by D2J-00 on 09/02/2017.
 */
public class Movie implements Serializable {
    public String title;
    public String disciption;
    public double rating;
    public int year;

    public Movie(String title, String disciption, double rating, int year) {
        this.title = title;
        this.disciption = disciption;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
