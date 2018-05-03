package com.example.nathan.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieAdapter.ItemListener{

    RecyclerView mRecyclerView;
    ArrayList arrayList;
    private MovieAdapter mAdapter;

    private static final int NUM_LIST_ITEMS = 100;

    final static String imageBaseURL = "https://image.tmdb.org/t/p/";
    final static String fileSize = "w185";
    // !!!!!!!!!!!!!!!!!!!!!!! PLEASE BE SURE TO NOT SHARE THIS ON GITHUB !!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!! THIS IS YOUR OWN PERSONAL KEY !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    final static String key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_movies);
        arrayList = new ArrayList();
        arrayList.add(new MovieModel("Item 1", 1, "#09A9FF")); // Here is where
        arrayList.add(new MovieModel("Item 2", 2, "#09A9FA")); // Here is where
        // we need to make an api call somewhere

        MovieAdapter adapter = new MovieAdapter(this, arrayList, this);
        mRecyclerView.setAdapter(adapter);

        com.example.nathan.popularmovies.GridLayoutManager layoutManager =
                new com.example.nathan.popularmovies.GridLayoutManager(this, 500);
        mRecyclerView.setLayoutManager(layoutManager);




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