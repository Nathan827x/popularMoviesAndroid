package com.example.nathan.popularmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Nathan on 4/21/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    ArrayList<MovieModel> mValues;
    Context mContext;
    protected ItemListener mListener;
    private static final String TAG = MovieAdapter.class.getSimpleName();
    private int number;

    public MovieAdapter (Context context, ArrayList values, ItemListener itemListener){
        mValues = values;
        mContext = context;
        mListener = itemListener;
        number = mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mMovieTitle;
        public ImageView mMoviePoster;
        public RelativeLayout layout;
        MovieModel MovieInstance;

        public ViewHolder(View v) {
            super(v);

            v.setOnClickListener(this);
            mMovieTitle = v.findViewById(R.id.tv_MovieTitle);
            mMoviePoster = v.findViewById(R.id.tv_MoviePoster);
            layout = v.findViewById(R.id.rl_SingleMovieLayout);
        }

        public void setData (MovieModel item){
            this.MovieInstance = item;
            mMovieTitle.setText(item.mMovieTitle);
            Picasso.get().load(item.mMoviePosterURL).into(mMoviePoster);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null){
                mListener.onItemClick(MovieInstance);
            }
        }
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.movie_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.setData(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return number;
    }

    public interface ItemListener {
        void onItemClick(MovieModel item);
    }
}
