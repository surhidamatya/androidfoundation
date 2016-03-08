package com.surdroid.understandingintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Intent can be defined as an Intention where you define what task to perform.
 * Those task can be:
 * <ul>
 * <li>Starting a new Activity</li>
 * <li>Pass values from one Activity to another activity</li>
 * <li>Open a link in device browser</li>
 * <li>Initiate a call</li>
 * <li>Use device camera</li>
 * </ul>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void explicitIntent(View v) {
        startActivity(new Intent(this, ListExplicitActivity.class));

    }

    public void implicitIntent(View view) {
        startActivity(new Intent(this, ListImplicitActivity.class));

    }
}
