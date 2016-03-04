package com.surdroid.understandingservice;

import android.app.ExpandableListActivity;
import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * IntentService is started as needed,
 * handles each Intent in turn using a worker thread,
 * and stops itself when it runs out of work.
 * Learn More:
 * <li><a href="http://developer.android.com/intl/es/reference/android/app/IntentService.html">Developer Link</></li>
 */
public class ExampleIntentService extends IntentService {

    private String IMAGE_DOWNLOAD_URL = "http://www.zastavki.com/pictures/1920x1200/2010/World_Australia_River_in_Australia_022164_.jpg";

    private static String TAG = ExampleService.class.getSimpleName();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public ExampleIntentService() {
        // Used to name the worker thread, important only for debugging.
        super("ExampleIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG + "---", "onCreate");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        /**
         *   Here you can handle what will happen when an Service is created
         *   IntentService will receive the Intents,
         *   launch a worker thread to perform the assigned task
         *
         */

//        startValueCounting();
// Sleep to waste time
        sleep(2000);
        downloadImage(IMAGE_DOWNLOAD_URL);

    }

    @Override
    public void onDestroy() {
        Toast.makeText(ExampleIntentService.this, "Image downloaded", Toast.LENGTH_SHORT).show();
        super.onDestroy();
        Log.i(TAG + "---", "onDestroy");
    }

    /**
     * Download image to view working way of Intent Service
     *
     * @param address link to download image from as String
     * @return downloaded image as {@link Bitmap}
     */

    protected Bitmap downloadImage(String address) {
        // Convert string to URL
        URL url = getUrlFromString(address);
        // Get input stream
        InputStream in = getInputStream(url);
        // Decode bitmap
        Bitmap bitmap = decodeBitmap(in);
        // Return bitmap result
        Log.i(TAG + "---", "on DownloadImage");
        return bitmap;
    }

    /**
     * Get URL link from passed on download link of image
     *
     * @param address download link of image as String
     * @return download link of image {@link URL}
     */
    private URL getUrlFromString(String address) {
        URL url;
        try {
            url = new URL(address);
        } catch (MalformedURLException e1) {
            url = null;
        }
        return url;
    }

    /**
     * Decode the image being downloaded
     *
     * @param in File being downloaded from given download link
     * @return image downloaded as Bitmap
     */
    private Bitmap decodeBitmap(InputStream in) {
        Bitmap bitmap;
        try {
            // Turn response into Bitmap
            bitmap = BitmapFactory.decodeStream(in);
            // Close the input stream
            in.close();
        } catch (IOException e) {
            in = null;
            bitmap = null;
        }
        return bitmap;
    }

    /**
     * Read the image being downloaded
     *
     * @param url path to download Image as {@link URL}
     * @return downloaded image as {@link InputStream}
     */
    private InputStream getInputStream(URL url) {
        InputStream in;
        // Open connection
        URLConnection conn;
        try {
            conn = url.openConnection();
            conn.connect();
            in = conn.getInputStream();
        } catch (IOException e) {
            in = null;
        }
        return in;
    }

    /**
     * Sleep the thread for a while to emulate the download
     *
     * @param millis time to sleep as Long
     */
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
