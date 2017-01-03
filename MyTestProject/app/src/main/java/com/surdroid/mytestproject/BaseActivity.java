package com.surdroid.mytestproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_base);
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.delegate = this;
        myAsyncTask.execute();

    }

    public void updateMessage(String message) {

    }


}
