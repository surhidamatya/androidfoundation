package com.lft.understandingandroidlifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Provides an overview of the most important lifecycle methods
 * and shows how to handle the lifecycle callback.
 * Learn more about lifecycle from
 * <ul>
 * <li><a href+"http://developer.android.com/intl/es/training/basics/activity-lifecycle/index.html">Developer Site</a></li>
 * <li><a href="https://github.com/xxv/android-lifecycle/tree/master/tools/LifecycleLog">Detail Example</a></li>
 * <p/>
 * <p/>
 * </ul>
 */

/**
 * Methods you override that are part of component creation (onCreate(), onStart(), onResume(), etc.),
 * you should chain to the superclass as the first statement,
 * to ensure that Android has its chance to do its work before you attempt to do something that relies upon that work having been done.
 * Methods you override that are part of component destruction (onPause(), onStop(), onDestroy(), etc.),
 * you should do your work first and chain to the superclass as the last thing.
 * That way, in case Android cleans up something that your work depends upon, you will have done your work first.
 * Methods that return something other than void (onCreateOptionsMenu(), etc.),
 * sometimes you chain to the superclass in the return statement,
 * assuming that you are not specifically doing something that needs to force a particular return value.
 * Everything else -- such as onActivityResult() -- is up to you, on the whole. tend to chain to the superclass as the first thing,
 * but unless you are running into problems, chaining later should be fine.
 * <p/>
 * If you want to be clear when do you want to call a method you need before or after super call.
 * Please visit
 * <ol>
 * <li><a href="http://stackoverflow.com/questions/9625920/should-the-call-to-the-superclass-method-be-the-first-statement/9626268#9626268">StackOverflow</a></li>
 * <li><a href="https://guides.codepath.com/android/Activity-Lifecycle">Code Path</a></li>
 * </ol>
 */
public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    /**
     * This is the first callback and called when the activity is first created.UI is not visible to users
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "OnCreate");
    }

    /**
     * The paused activity does not receive user input and cannot execute any code and called
     * when the current activity is being paused and the previous activity is being resumed.
     * Activity is preparing itself to go in background and will not receive any user interaction
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OnPause");
    }

    /**
     * This is called when the user starts interacting with the application as activity is brought foreground.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "OnResume");
    }

    /**
     * This callback is called before the activity is destroyed by the system or finish() is called upon programmatically
     */
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
     * This callback is called when the activity becomes visible to the user but not ready for the user interaction.
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

    public void startSecondActivity(View view) {
        startActivity(new Intent(this, SecondActivity.class));

    }
}
