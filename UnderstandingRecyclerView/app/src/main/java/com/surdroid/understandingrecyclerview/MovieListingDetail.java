package com.surdroid.understandingrecyclerview;

/**
 * Created by surhid on 8/20/16.
 */

public class MovieListingDetail {

    private String movieName;
    private int moviePosterPath;

    public MovieListingDetail(String movieName, int moviePosterPath) {
        this.movieName = movieName;
        this.moviePosterPath = moviePosterPath;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMoviePosterPath() {
        return moviePosterPath;
    }

    public void setMoviePosterPath(int moviePosterPath) {
        this.moviePosterPath = moviePosterPath;
    }
}
