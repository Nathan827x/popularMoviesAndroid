package com.example.nathan.popularmovies;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
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
        GetCall APIRequest = new GetCall();
        String ReturnedData;
        ReturnedData = APIRequest.GetRequest(SearchURL + String.valueOf(mPageNumber));

        if (ReturnedData != null) {
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


}

    class GetCall{
    OkHttpClient client = new OkHttpClient();
    String GetRequest(String url) {
        final String[] result = new String[1];
        Request request = new Request.Builder()
                .url(url)
                .build();

//        Response response = client.newCall(request).execute();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()){
                        throw new IOException("Unexpected code " + response);
                    } else {
                        result[0] = response.body().string();
                    }
                }
            });
            return result[0];
        }
    }