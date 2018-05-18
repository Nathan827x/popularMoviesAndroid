package com.example.nathan.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieAdapter.ItemListener{

    RecyclerView mRecyclerView;
    MovieAPICall arrayList;
    // !!!!!!!!!!!!!!!!!!!!!!! PLEASE BE SURE TO NOT SHARE THIS ON GITHUB !!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!! THIS IS YOUR OWN PERSONAL KEY !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private String API_KEY = "?api_key=";
    // Notes
    // When making the api call to get the most popular movies, there are 20 movies per page
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_movies);

        arrayList = new MovieAPICall(1, API_KEY);

        //        arrayList = new ArrayList();
//        arrayList.add(new MovieModel("MovieTitle1", "http://image.tmdb .org/t/p/w185/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg")); // Here is where
//        arrayList.add(new MovieModel("MovieTitle2", "http://image.tmdb.org/t/p/w185/jjPJ4s3DWZZvI4vw8Xfi4Vqa1Q8.jpg")); // Here is where
        // we need to make an api call somewhere

        arrayList.ArrayAPICall(new MovieAPICall.ResponseListener() {
            @Override
            public void onFailure(int errorCode) {
                Log.d("Error", errorCode + "");
            }

            @Override
            public void onSuccess(final ArrayList data) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new MovieAdapter(MainActivity.this, data, MainActivity.this);
                        mRecyclerView.setAdapter(adapter);
                        GridLayoutManager layoutManager =
                                new GridLayoutManager(MainActivity.this, 500);
                        mRecyclerView.setLayoutManager(layoutManager);
                    }
                });

            }
        });


//        // Testing picasso library
//        ImageView mMoviePicture = findViewById(R.id.tv_moviePicture);
//        ImageView test2 = findViewById(R.id.testImage2);
//        ImageView test3 = findViewById(R.id.testImage3);
//        ImageView test4 = findViewById(R.id.testImage4);
//
//
//        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(mMoviePicture);
//        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(test2);
//        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(test3);
//        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(test4);
    }

    @Override
    public void onItemClick(MovieModel item) {

    }
}