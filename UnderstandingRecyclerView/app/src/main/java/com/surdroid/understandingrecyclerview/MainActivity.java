package com.surdroid.understandingrecyclerview;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMovieListing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovieListing = findViewById(R.id.rv_example_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvMovieListing.setLayoutManager(gridLayoutManager);

 /*
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvMovieListing.setLayoutManager(staggeredGridLayoutManager);

         LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvMovieListing.setLayoutManager(linearLayoutManager);

         GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvMovieListing.setLayoutManager(gridLayoutManager);


        */

        rvMovieListing.setAdapter(new MovieListingAdapter(getMovieList()));

    }

    private ArrayList<MovieListingDetail> getMovieList() {
        ArrayList<MovieListingDetail> moviesList = new ArrayList<>();
        moviesList.add(new MovieListingDetail("Sultan", R.drawable.sultan));
        moviesList.add(new MovieListingDetail("Bajrangi Bhaijaan", R.drawable.bajrangi));
        moviesList.add(new MovieListingDetail("Kick", R.drawable.kick));
        moviesList.add(new MovieListingDetail("Jai Ho", R.drawable.jaiho));
        return moviesList;
    }
}
