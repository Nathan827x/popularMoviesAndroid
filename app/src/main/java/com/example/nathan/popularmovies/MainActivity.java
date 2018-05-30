package com.example.nathan.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.SortedList;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.nathan.popularmovies.api.MovieAPICall;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MovieAdapter.ItemListener{

    RecyclerView mRecyclerView;
    MovieAPICall arrayList;
    // !!!!!!!!!!!!!!!!!!!!!!! PLEASE BE SURE TO NOT SHARE THIS ON GITHUB !!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!! THIS IS YOUR OWN PERSONAL KEY !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private String API_KEY = "?api_key=e5d9e7a3d1a18c5caa632a613d622aae";
    // Notes
    // When making the api call to get the most popular movies, there are 20 movies per page
    MovieAdapter adapter;
    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_movies);
        adapter = new MovieAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 500);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                LoadNextData(page + 1);
            }
        };
        mRecyclerView.addOnScrollListener(scrollListener);


//        loadData(1, API_KEY);

        //        arrayList = new ArrayList();
//        arrayList.add(new MovieModel("MovieTitle1", "http://image.tmdb .org/t/p/w185/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg")); // Here is where
//        arrayList.add(new MovieModel("MovieTitle2", "http://image.tmdb.org/t/p/w185/jjPJ4s3DWZZvI4vw8Xfi4Vqa1Q8.jpg")); // Here is where
        // we need to make an api call somewhere


//        TODO 1 Try and separate the data and instantiating the adapter
//        TODO 2 if this works, you can use the EndlessRecyclerViewScrollListener to make your calls
//        TODO 3 if that doesn't work try making another function for all api call.


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
        Toast.makeText(this, "This is on the main page", Toast.LENGTH_SHORT).show();

    }

    private List<Result> fetchResults(Response<MovieModel> response) {
        MovieModel model = response.body();
        return topRatedMovies.getResults();
    }

    private void LoadNextData(int page){
        Log.d(TAG, "loadNextPage: " + page);

        MovieAPICall().enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                adapter.removeLoadingFooter();

                List<Result> results = fetchResults(response);
                adapter.addAll(results);

                if (currentPage != TOTAL_PAGES) adapter.addLoadingFooter();
                else isLastPage = true;
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

//    private void loadData(int page, String API){
//        arrayList = new MovieAPICall(page, API);
//        arrayList.ArrayAPICall(new MovieAPICall.ResponseListener() {
//            @Override
//            public void onFailure(int errorCode) {
//                Log.d("Error", errorCode + "");
//            }
//
//            @Override
//            public void onSuccess(final ArrayList data) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        adapter = new MovieAdapter(MainActivity.this, data, MainActivity.this);
//                        mRecyclerView.setAdapter(adapter);
//                        GridLayoutManager layoutManager =
//                                new GridLayoutManager(MainActivity.this, 500);
//                        mRecyclerView.setLayoutManager(layoutManager);
//                    }
//                });
//
//            }
//        });
//    }
}