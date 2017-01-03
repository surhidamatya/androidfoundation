package com.surdroid.mytestproject;

import android.os.AsyncTask;

/**
 * Created by surhid on 12/2/16.
 */

public class MyAsyncTask extends AsyncTask<Void, Void, String> {
    public BaseActivity delegate = null;

    @Override
    protected String doInBackground(Void... voids) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        delegate.updateMessage(s);
    }
}
