package com.example.nathan.popularmovies.api;

import com.example.nathan.popularmovies.models.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nathan on 5/26/2018.
 */

public interface APIService {

    @GET("top_rated")
    Call<MovieModel> getTopRatedMovies(
            @Query("api_key") String apiKey,
            @Query("page") int pageIndex
    );
}
