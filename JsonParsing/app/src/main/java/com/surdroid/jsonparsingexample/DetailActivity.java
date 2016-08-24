package com.surdroid.jsonparsingexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.surdroid.jsonparsingexample.rest.response.Result;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Result movieDetail = (Result) intent.getExtras().get("Movie_Detail");

        Log.i(TAG, "onCreate: " + movieDetail.getOriginalTitle());
        Log.i(TAG, "onCreate: " + movieDetail.getReleaseDate());
    }

    public static Intent getLaunchIntent(Context context, Result result) {
        Intent movieDetailActivityIntent = new Intent(context, DetailActivity.class);
        movieDetailActivityIntent.putExtra("Movie_Detail", result);
        return movieDetailActivityIntent;
    }
}
