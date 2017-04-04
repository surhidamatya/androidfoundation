package com.nagariknews.hawkerapp;

import android.app.Application;
import android.content.Context;

/**
 * Application class for Hawker Application
 */

public class HawkerApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
    }

    public static Context getContext() {
        return context;
    }

}
