package com.surdroid.mytestproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String name = "alksjasd";

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate();

    }

    /**
     * Initialize view
     */
    private void calculate() {
        double a = addition(2, 3);

        Log.i(TAG, "onCreate: " + a);
    }

    private int addition(int a, int b) {

        int sum = a + b;
        return sum;
    }
}
