package com.example.nathan.popularmovies;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieAPICall{

    public int mPageNumber;
    final static private String BaseURL =  "https://api.themoviedb.org/3/discover/movie";
    final static private String Filter = "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=";

    public String SearchURL;

    public MovieAPICall(int page, String API_KEY) {
        SearchURL = BaseURL + API_KEY + Filter ;
        mPageNumber = page;
    }

    public ArrayList ArrayAPICall() throws IOException {

        String ReturnedData = run(SearchURL + String.valueOf(mPageNumber));
        if (ReturnedData != "") {
            CreateMovieArrayList MovieArrayList = new CreateMovieArrayList(ReturnedData);
            ArrayList Results = MovieArrayList.CreateArray();
            return Results;
        }

//        Complete 2 create a JsonUtils class to handle the formatting the data
//        Complete 3 Store the data in an array list
//        Complete 4 Pass the list back to main and Create a new Class
//        Complete 4.1 New class will handle creating the array and passing it to the adapater to be displayed.
        return null;
    }

    OkHttpClient client = new OkHttpClient();
    public String run(String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
    }
}
