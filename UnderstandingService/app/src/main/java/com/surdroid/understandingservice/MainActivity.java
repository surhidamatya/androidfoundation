package com.surdroid.understandingservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * A service is a component which runs in the background and does not have any UI
 * As the service has no user interface it is not bound to the lifecycle of an activity.
 * Services are used for repetitive and potential long running operations, checking for new data, data processing, indexing content, etc.
 *
 * Decide when to use Service or IntentService
 * <b><a href="http://stackoverflow.com/questions/15524280/service-vs-intentservice">Service vs. Intent Service</a></b>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startBasicService(View v) {

        Intent intent = new Intent(MainActivity.this, ExampleService.class);
        startService(intent);

    }

    public void startBasicIntentService(View v) {
        Intent intent = new Intent(MainActivity.this, ExampleIntentService.class);
        startService(intent);
    }

    public void stopBasicService(View v) {
        Intent intent = new Intent(MainActivity.this, ExampleService.class);
        stopService(intent);

    }
}
