package com.example.nathan.popularmovies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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

    @SerializedName("results")
    @Expose
    private List<APIResults> results = new ArrayList<APIResults>();

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

    public List<APIResults> getResults() {
        return results;
    }

    public void setResults(List<APIResults> results) {
        this.results = results;
    }


}
