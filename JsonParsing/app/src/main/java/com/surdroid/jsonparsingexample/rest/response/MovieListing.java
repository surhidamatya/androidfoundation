
package com.surdroid.jsonparsingexample.rest.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieListing implements Parcelable {

    @SerializedName("page")
    private Integer page;

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("total_results")
    private Integer totalResults;

    @SerializedName("results")
    private ArrayList<Result> results = new ArrayList<Result>();

    @SerializedName("dates")
    private Dates dates;

    protected MovieListing(Parcel in) {
        results = in.createTypedArrayList(Result.CREATOR);
        dates = in.readParcelable(Dates.class.getClassLoader());
    }

    public static final Creator<MovieListing> CREATOR = new Creator<MovieListing>() {
        @Override
        public MovieListing createFromParcel(Parcel in) {
            return new MovieListing(in);
        }

        @Override
        public MovieListing[] newArray(int size) {
            return new MovieListing[size];
        }
    };

    /**
     * @return The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * @return The results
     */
    public ArrayList<Result> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    /**
     * @return The dates
     */
    public Dates getDates() {
        return dates;
    }

    /**
     * @param dates The dates
     */
    public void setDates(Dates dates) {
        this.dates = dates;
    }

    /**
     * @return The totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages The total_pages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * @return The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * @param totalResults The total_results
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /* ## Parcelable Implementation ## */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(results);
        parcel.writeParcelable(dates, i);
    }
}
