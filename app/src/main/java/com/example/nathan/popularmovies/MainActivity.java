package com.example.nathan.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    final static String imageBaseURL = "https://image.tmdb.org/t/p/";
    final static String fileSize = "w185";
    // !!!!!!!!!!!!!!!!!!!!!!! PLEASE BE SURE TO NOT SHARE THIS ON GITHUB !!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!! THIS IS YOUR OWN PERSONAL KEY !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    final static String key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);




        // Testing picasso library
        ImageView mMoviePicture = findViewById(R.id.tv_moviePicture);
        ImageView test2 = findViewById(R.id.testImage2);
        ImageView test3 = findViewById(R.id.testImage3);
        ImageView test4 = findViewById(R.id.testImage4);


        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(mMoviePicture);
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(test2);
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(test3);
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(test4);


    }
}