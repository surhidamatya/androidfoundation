package com.surdroid.jsonparsingexample.rest;

import com.surdroid.jsonparsingexample.rest.response.MovieListing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ashish on 7/28/2016.
 */
public interface MovieListingService {

    @GET("upcoming")
    Call<MovieListing> getUpcomingMovies(@Query("api_key") String apiKey);

}