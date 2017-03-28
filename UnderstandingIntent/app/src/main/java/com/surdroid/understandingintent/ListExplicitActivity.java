package com.surdroid.understandingintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Explicit Intent is used to launch other activities.
 */
public class ListExplicitActivity extends AppCompatActivity {

    private static final String TAG = ListExplicitActivity.class.getSimpleName();
    LinearLayout llLayoutPassIntent;
    EditText edtValueOne;
    EditText edtValueTwo;
    TextView txtVwResult;

    public static int RESULT_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_explicit);
        llLayoutPassIntent = (LinearLayout) findViewById(R.id.ll_layout_pass_value);
        edtValueOne = (EditText) findViewById(R.id.edt_value_one);
        edtValueTwo = (EditText) findViewById(R.id.edt_value_two);
        txtVwResult = (TextView) findViewById(R.id.txt_vw_result);
    }

    /**
     * Start {@link ListExplicitActivityTwo} when button is pressed to showcase {@link Intent} ca be used to start new activities
     */
    public void startNewActivity(View v) {
        startActivity(new Intent(this, ListExplicitActivityTwo.class));
        finish();

    }

    public void passIntentActivity(View v) {
        llLayoutPassIntent.setVisibility(View.VISIBLE);

    }

    /**
     * Start {@link ListExplicitActivityPassedValue}
     * when button is pressed to showcase {@link Intent}
     * can be used to pass on values from one {@link android.app.Activity} to another
     * Also try
     *
     * @see <a href="http://developer.android.com/intl/es/reference/android/os/Bundle.html">Bundle</a>
     * @see <a href="http://developer.android.com/intl/es/reference/android/os/Parcelable.html">Parcelable</a>
     * to pass on values
     */
    public void passIntentValueActivity(View v) {
        String valueOne = edtValueOne.getText().toString().trim();
        String valueTwo = edtValueTwo.getText().toString().trim();
        if (valueOne.isEmpty()) {
            edtValueOne.setError("Cannot be empty");
        } else if (valueTwo.isEmpty()) {
            edtValueTwo.setError("Cannot be empty");
        } else {

            Intent passIntentValue = new Intent(this, ListExplicitActivityPassedValue.class);
            passIntentValue.putExtra(Constants.VALUE_ONE, valueOne);
            passIntentValue.putExtra(Constants.VALUE_TWO, valueTwo);
            startActivity(passIntentValue);
            finish();
        }
    }

    /**
     * Showcase Intent can be used to wait for an result if needed
     * {@link ListExplicitActivityPassedValue} is started and waits for result from it.
     */
    public void startNewActivityForResult(View v) {
        Intent passIntentValue = new Intent(this, ListExplicitActivityPassedValue.class);
        passIntentValue.putExtra(Constants.FOR_ACTIVITY_RESULT, true);
        startActivityForResult(passIntentValue, RESULT_CODE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult: " + requestCode + "::" + resultCode);
        // check if the request code is same as what is passed  here it is 2
        if (resultCode == RESULT_CODE) {
            txtVwResult.setVisibility(View.VISIBLE);
            String message = data.getStringExtra(Constants.VALUE_ONE);
            txtVwResult.setText(message);
        } else {
            txtVwResult.setVisibility(View.VISIBLE);
            txtVwResult.setText("No value");
        }
    }
}
