package com.surdroid.jsonparsingexample.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ashish on 7/29/2016.
 */
public class Genres {

    @SerializedName("id")
    private int genreId;

    @SerializedName("name")
    private String genreName;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
