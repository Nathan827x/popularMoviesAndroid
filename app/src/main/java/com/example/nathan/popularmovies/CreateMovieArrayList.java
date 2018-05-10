package com.example.nathan.popularmovies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
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
            JSONObject SearchResults = jsonObject.getJSONObject("results");

            JSONObject MovieTitle;
            JSONObject PosterPath;
            ArrayList Results = new ArrayList();
            for (int i = 0; i < SearchResults.length(); i++){
                MovieTitle = SearchResults.getJSONObject("title");
                PosterPath = SearchResults.getJSONObject("poster_path");

                Results.add(new MovieModel(MovieTitle.toString(), imageURL + PosterPath));
            }
            return Results;

        } catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

}
