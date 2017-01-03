package com.surdroid.implementcryptomanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.rajesh.library.CryptoManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CryptoManager cryptoManager = CryptoManagerApplication.getCryptoManager();
        cryptoManager.decrypt(cryptoManager.encrypt("hello testing"));

        Log.d(TAG, "onCreate: " + cryptoManager.decrypt(cryptoManager.encrypt("hello testing")));


    }
}
