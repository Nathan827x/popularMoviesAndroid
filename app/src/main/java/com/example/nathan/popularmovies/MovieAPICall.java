package com.example.nathan.popularmovies;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieAPICall {

    public int mMovieArraySize;

    // HTTP get request
    final static String imageBaseURL = "https://image.tmdb.org/t/p/";
    final static String fileSize = "w185";
    // !!!!!!!!!!!!!!!!!!!!!!! PLEASE BE SURE TO NOT SHARE THIS ON GITHUB !!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!! THIS IS YOUR OWN PERSONAL KEY !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    final static String key = "api_key=e5d9e7a3d1a18c5caa632a613d622aae";

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public void MovieAPICall(int numberOfMovies){
        mMovieArraySize = numberOfMovies;

        APICall();
    }

    private void APICall() {
        run(imageBaseURL + )
    }
}
