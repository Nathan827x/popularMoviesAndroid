package com.example.nathan.popularmovies;

import com.example.nathan.popularmovies.models.MovieModel;

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

    String mJson;

    public CreateMovieArrayList(String json) {
        mJson = json;
    }

    public ArrayList CreateArray(){
        try {
            JSONObject jsonObject = new JSONObject(mJson);
            JSONArray SearchResults = jsonObject.getJSONArray("results");
//            JSONObject SearchResults = jsonObject.getJSONObject("results");

//            JSONObject MovieTitle;
//            JSONObject PosterPath;
            String MovieTitle;
            String PosterPath;
            int MovieID;
            ArrayList Results = new ArrayList();
            for (int i = 0; i < SearchResults.length(); i++){
                JSONObject Movie = SearchResults.getJSONObject(i);
                MovieTitle = Movie.getString("title");
                PosterPath = Movie.getString("poster_path");
                MovieID = Movie.getInt("id");
                Results.add(new MovieModel(MovieTitle, imageURL + PosterPath, MovieID));
            }
            return Results;

        } catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

}
