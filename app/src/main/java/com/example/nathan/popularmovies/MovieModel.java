package com.example.nathan.popularmovies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieModel {

    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("original_title")
    @Expose
    private String mMovieTitle;

    @SerializedName("poster_path")
    @Expose
    private String mMoviePosterURL;

    @SerializedName("id")
    @Expose
    private int mMovieID;

    public String getTitle(){
        return mMovieTitle;
    }

    public void setTitle(String title){
        mMovieTitle = title;
    }

    public String getPoster(){
        return mMoviePosterURL;
    }

    public void setPoster(String poster){
        mMoviePosterURL= poster;
    }

    public int getMovieID(){
        return mMovieID;
    }

    public void setMovieID(int id) {
        mMovieID = id;
    }

}
