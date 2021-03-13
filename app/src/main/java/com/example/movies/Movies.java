package com.example.movies;

import java.util.ArrayList;

public class Movies {

    public String getMovieID() {
        return movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getUserRating() {
        return userRating;
    }

    public String getDetailsImage() {
        return detailsImage;
    }

    private String movieID;
    private String movieTitle;
    private String movieImage;
    private String overview;
    private String releaseDate;
    private String userRating;
    private String detailsImage;

    // This method is the constructor, called on the receiving activity, where you will be collecting values.
    // This constructor is where you set up the values and set up the properties of the object. At this point
    // you have populated the object with data

    // CONSTRUCTOR calling all movie attributes

    public Movies(String title, String mImage, String overview, String date, String rating, String mmImage, String id) {

        movieTitle = title;
        movieImage = mImage;
        this.overview = overview;
        releaseDate = date;
        userRating = rating;
        detailsImage = mmImage;
        movieID = id;
    }

}
