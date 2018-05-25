package com.example.nathan.popularmovies;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MovieAPICall{

    public int mPageNumber;
    final static private String BaseURL =  "https://api.themoviedb.org/3/discover/movie";
    final static private String Filter = "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=";
    public String SearchURL;

    private static Retrofit retrofit = null;

    public MovieAPICall(int page, String API_KEY) {
        SearchURL = BaseURL + API_KEY + Filter ;
        mPageNumber = page;
    }

    public void ArrayAPICall(ResponseListener responseListener){
        GetCall APIRequest = new GetCall();
        APIRequest.GetRequest(SearchURL + String.valueOf(mPageNumber), responseListener);

//        Complete 2 create a JsonUtils class to handle the formatting the data
//        Complete 3 Store the data in an array list
//        Complete 4 Pass the list back to main and Create a new Class
//        Complete 4.1 New class will handle creating the array and passing it to the adapater to be displayed.
    }

    public static Retrofit GetCall(Context context) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.themoviedb.org/3/")
                    .build();
        }
        return retrofit;

        @GET("top_rated")
        Call<TopRatedMovies> getTopRatedMovies(
                @Query("api_key") String apiKey,
                @Query("language") String language,
        @Query("page") int pageIndex
    );

}

