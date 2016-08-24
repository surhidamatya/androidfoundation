package com.surdroid.jsonparsingexample.rest.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ashish on 7/29/2016.
 */
public class MovieDetail {
    private boolean adult;
    private String backdrop_path;
    private String belongs_to_collection;
    private double budget;
    private String homepage;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private float popularity;
    private String poster_path;
    private String release_date;
    private double revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private int vote_average;
    private int vote_count;

    @SerializedName("genres")
    ArrayList<Genres> movieGenre;

    @SerializedName("production_companies")
    ArrayList<ProductionCompanies> productionCompaniesArrayList;

    @SerializedName("production_countries")
    ArrayList<ProductionCountries>productionCountriesArrayList;

    @SerializedName("spoken_languages")
    ArrayList<SpokenLanguage>spokenLanguageArrayList;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(String belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public int getVote_average() {
        return vote_average;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public ArrayList<Genres> getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(ArrayList<Genres> movieGenre) {
        this.movieGenre = movieGenre;
    }

    public ArrayList<ProductionCompanies> getProductionCompaniesArrayList() {
        return productionCompaniesArrayList;
    }

    public void setProductionCompaniesArrayList(ArrayList<ProductionCompanies> productionCompaniesArrayList) {
        this.productionCompaniesArrayList = productionCompaniesArrayList;
    }

    public ArrayList<ProductionCountries> getProductionCountriesArrayList() {
        return productionCountriesArrayList;
    }

    public void setProductionCountriesArrayList(ArrayList<ProductionCountries> productionCountriesArrayList) {
        this.productionCountriesArrayList = productionCountriesArrayList;
    }

    public ArrayList<SpokenLanguage> getSpokenLanguageArrayList() {
        return spokenLanguageArrayList;
    }

    public void setSpokenLanguageArrayList(ArrayList<SpokenLanguage> spokenLanguageArrayList) {
        this.spokenLanguageArrayList = spokenLanguageArrayList;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
