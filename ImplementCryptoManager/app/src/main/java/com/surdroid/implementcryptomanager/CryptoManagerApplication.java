package com.surdroid.implementcryptomanager;

import android.app.Application;
import android.content.Context;

import com.rajesh.library.CryptoFactory;
import com.rajesh.library.CryptoManager;

/**
 * Created by surhid on 12/28/16.
 */

public class CryptoManagerApplication extends Application {

    public static CryptoManager cryptoManager;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
    }

    public static CryptoManager getCryptoManager() {
        return cryptoManager = CryptoFactory.getInstance(context);
    }
}
