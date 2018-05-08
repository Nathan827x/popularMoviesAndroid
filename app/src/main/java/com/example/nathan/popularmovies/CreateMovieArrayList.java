package com.example.nathan.popularmovies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Nathan on 5/6/2018.
 */

public class CreateMovieArrayList {

    final static String ImageBaseURL = "https://image.tmdb.org/t/p/";
    final static String ImageSize = "w185";
    public String imageURL = ImageBaseURL + ImageSize;

    public ArrayList MovieList;

    public CreateMovieArrayList(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray SearchResults = jsonObject.getJSONArray("results");

            ArrayList Results;
            String MovieTitle;
            String ImageURL;
            for (int i = 0; i < SearchResults.length(); i++){
                MovieTitle = SearchResults.getJSONObject("title");


                Results.add(MovieTitle, ImageURL);
            }


        } catch (JSONException e){
            e.printStackTrace();
        }
    }

}
