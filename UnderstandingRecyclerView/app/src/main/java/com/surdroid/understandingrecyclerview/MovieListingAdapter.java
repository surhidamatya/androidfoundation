package com.surdroid.understandingrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by surhid on 8/20/16.
 */

public class MovieListingAdapter extends RecyclerView.Adapter<MovieListingAdapter.MovieListingViewHolder> {

    private ArrayList<MovieListingDetail> movieListingDetailArrayList;

    public MovieListingAdapter(ArrayList<MovieListingDetail> movieListingDetailArrayList) {
        this.movieListingDetailArrayList = movieListingDetailArrayList;
    }

    @Override
    public MovieListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_listing, parent, false);
        MovieListingViewHolder rcv = new MovieListingViewHolder(layoutView);
        return rcv;

    }

    @Override
    public void onBindViewHolder(MovieListingViewHolder holder, int position) {

        holder.tvMovieName.setText(movieListingDetailArrayList.get(position).getMovieName());
        holder.ivMoviePoster.setImageResource(movieListingDetailArrayList.get(position).getMoviePosterPath());
    }

    @Override
    public int getItemCount() {
        return movieListingDetailArrayList.size();
    }

    public class MovieListingViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivMoviePoster;
        public TextView tvMovieName;

        public MovieListingViewHolder(View itemView) {
            super(itemView);

            ivMoviePoster = itemView.findViewById(R.id.iv_movie_poster);
            tvMovieName = itemView.findViewById(R.id.tv_movie_name);
        }
    }
}
