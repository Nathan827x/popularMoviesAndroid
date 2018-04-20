package com.example.nathan.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    final static String imageBaseURL = "https://image.tmdb.org/t/p/";
    final static String fileSize = "w185";
    // !!!!!!!!!!!!!!!!!!!!!!! PLEASE BE SURE TO NOT SHARE THIS ON GITHUB !!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!! THIS IS YOUR OWN PERSONAL KEY !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    final static String key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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