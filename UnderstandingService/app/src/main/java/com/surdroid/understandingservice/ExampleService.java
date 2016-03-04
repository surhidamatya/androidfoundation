package com.surdroid.understandingservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * The Service runs in background but it runs on the Main Thread of the application.
 * Stop the service when its work is done, by calling stopSelf() or stopService().
 *
 * @see <a href="http://developer.android.com/intl/es/guide/components/services.html">Developer site</a>
 */
public class ExampleService extends Service {

    private ArrayList<Integer> someArrList = new ArrayList<>();

    private static String TAG = ExampleService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG + "---", "onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG + "---", "onStartCommand");
        simulateLowMemory();
        /**
         * Service is not restarted. Used for services which are periodically triggered anyway.
         * The service is only restarted if the runtime has pending startService() calls since the service termination.
         */
        return START_NOT_STICKY;
        /**
         * Similar to Service.START_STICKY but the original
         * Intent is re-delivered to the onStartCommand method.
         */
//        return START_REDELIVER_INTENT;
        /**
         * Service is restarted if it gets terminated.
         * Intent data passed to the onStartCommand method is null.
         * Used for services which manages their own state and do not depend on the Intent data.
         */
//        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(ExampleService.this, "Image downloaded", Toast.LENGTH_SHORT).show();
        super.onDestroy();
        Log.i(TAG + "---", "onDestroy");
    }

    /**
     * A service runs in the main thread of its hosting process—the service does not create its own thread and
     * does not run in a separate process (unless you specify otherwise).
     * If service is going to do any CPU intensive work or blocking operations (such as MP3 playback or networking),
     * you should create a new thread within the service to do that work.
     * Reduce the risk of Application Not Responding (ANR) errors by using separate thread to use long running task
     * so the application's main thread can remain dedicated to user interaction with your activities.
     *
     * @see <a href="http://developer.android.com/intl/es/training/articles/perf-anr.html">ANR</a>
     */
    private void simulateLowMemory() {

        for (int i = 0; i < 999999; i++) {
            Log.i(TAG + "---", "simulateLowMemory");
            someArrList.add(new Integer(i));
        }
    }
}
