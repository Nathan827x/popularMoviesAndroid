package com.example.nathan.popularmovies;

public class MovieModel {
    public String mMovieTitle;
    public String mMoviePosterURL;
    public int mMovieID;

    public MovieModel(String title, String poster, int MovieID){
        mMovieTitle = title;
        mMoviePosterURL = poster;
        mMovieID = MovieID;
    }

}
