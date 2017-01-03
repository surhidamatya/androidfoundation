package com.surdroid.recyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMovieListing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovieListing = (RecyclerView) findViewById(R.id.rv_example_view);

       /* LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvMovieListing.setLayoutManager(linearLayoutManager);
*/
       /* GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rvMovieListing.setLayoutManager(gridLayoutManager);*/

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvMovieListing.setLayoutManager(staggeredGridLayoutManager);

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
