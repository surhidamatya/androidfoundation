package com.lft.understandingandroidlifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    private static String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.i(TAG, "OnCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "OnResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "OnDestroy");
    }

    /**
     * This callback is called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "OnStop");
    }

    /**
     * This callback is called when the activity becomes visible to the user.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "OnStart");
    }

    /**
     * This callback is called when the activity restarts after stopping it.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "OnReStart");
    }

    public void stopSecondActivity(View view) {
        finish();

    }
}
