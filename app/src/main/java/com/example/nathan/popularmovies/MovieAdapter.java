package com.example.nathan.popularmovies;

import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Nathan on 4/21/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private static final String TAG = MovieAdapter.class.getSimpleName();

    private int mNumberItems;

    // Constructor
    public void MovieAdapter(int numberOfMovies){
        mNumberItems = numberOfMovies;
    }


    @Override
    public MovieViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder( MovieViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MovieViewHolder {

    }
}
