package com.example.nathan.popularmovies;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieAPICall {

    public int mPageNumber;
    final static private String BaseURL =  "https://api.themoviedb.org/3/discover/movie";
    final static private String Filter = "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=";

    public String SearchURL;

    OkHttpClient client = new OkHttpClient();



    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public MovieAPICall(int page, String API_KEY) throws IOException {
        SearchURL = BaseURL + API_KEY + Filter;
        mPageNumber = page;

        ArrayAPICall();
    }

    public CreateMovieArrayList ArrayAPICall() throws IOException {
        String ReturnedData = run(SearchURL + String.valueOf(mPageNumber));

//        TODO 2 create a JsonUtils class to handle the formatting the data
//        TODO 3 Store the data in an array list
//        TODO 4 Pass the list back to main and Create a new Class
//        TODO 4.1 New class will handle creating the array and passing it to the adapater to be displayed.
        return new CreateMovieArrayList(ReturnedData);
    }
}
